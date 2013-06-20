/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.Organisms;

import biology.simulation.BiologySimulation;
import biology.simulation.GUI;
import biology.simulation.Grave;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Will
 */
public class Reaper extends Organism{
    public int kills;
    public static int maxKills;
    public static boolean isPresent;

    public Reaper()
    {
        this.kills = 0;
        maxKills = 0;
        Reaper.isPresent = true;
    }
    
    public void setMaxKills()
    {
        int d = (int)(BiologySimulation.orgCount *Math.random())+5;
        maxKills = d;     
        GUI.remAppend("Maximum Kill Limit set to: "+maxKills);
    }

    public static void setMaxKillsWindow()
    {
        int x = 400, y = 200;
        final JFrame frame = new JFrame();
        JButton send = new JButton("Ok");
        frame.setSize(x,y);
        final JTextField tf = new JTextField(10);// accepts upto 10 characters   
        
        final String in = tf.getText();
        final Scanner sc = new Scanner(in);
        
        frame.show();
        send.addActionListener(new ActionListener(){    
            @Override    
            public void actionPerformed(ActionEvent send) {
                //In response to a button click:                        
                String h = tf.getText();
                if(h.equals("")){
                    frame.dispose();
                }                
                else if(sc.hasNextInt()){
                    final int i = sc.nextInt();
                    maxKills = i;
                    frame.dispose();
                }
                frame.dispose();
            }//keyA Action
        });//keyA event     
    }
    
    @Override
    public void act() {
        //Checking for adjacent Organisms
        ArrayList<Organism> list = this.getNeighbourOrganismsFromArrayList(getNeighbours(this.getLocation()));
        this.destroy(list);    
        // Random move
        
        double rndmMove = Math.random();
        
        if(this.kills >= maxKills){
            GUI.remAppend("Death's job is complete. \n "+this.kills+" kills");
            this.removeSelfFromGrid();
            isPresent = false;
            BiologySimulation.world.show();
        }
        if (rndmMove < 0.75) {
            if (canMove()) {
                move();
            } else {
                turn();
            }
        } else {
            randomTurn();
        }
        
        
        //Checking for adjacent Organisms after moving
        /*ArrayList<Organism> list2 = this.getNeighbourOrganismsFromArrayList(getNeighbours(this.getLocation()));
        for (int i = 0; i < list2.size(); i++) {
            if (getGender().equalsIgnoreCase(list2.get(i).getGender())) {
                System.out.println(this.name + " has same gender as " + list2.get(i).name);
            } else {
                System.out.println(this.name + " has different gender than " + list2.get(i).name);
              }
        }*/
        //Aging - Steps until death

            
    }
    
    public void seek()
    {
    }
    
    public void destroy(ArrayList<Organism> list)
    {
        for(int n = 0; n < list.size(); n++)
        {
            Grave grave = new Grave(list.get(n));
            Location loc = list.get(n).getLocation();
            list.get(n).removeSelfFromGrid();
            BiologySimulation.world.add(loc, grave);
            
            BiologySimulation.orgCount--;
            ++kills;
            BiologySimulation.world.show();
        }
        
    }
    
}