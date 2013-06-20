package biology.simulation;

import biology.Organisms.Organism;
import biology.misc.Count;
import biology.misc.SplashScreen;
import biology.misc.Splasher;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import javax.swing.JFrame;
import java.util.*;
import java.io.*;

/**
 *
 *
 *
 * @author Will
 *
 */
public class BiologySimulation {

    /**
     *
     * @param args the command line arguments
     *
     */
    static String in1;
    public static int orgCount;
    public static ActorWorld world;
    public static ArrayList<Count> counts = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        //SplashScreen.newSplash();
        //Splasher.createAndShowGUI();

        GUI gui = new GUI();
        ArrayList orgList = Organism.newMetricTonOfOrganisms(10);
        BoundedGrid grid = new BoundedGrid(13, 13);
        world = new ActorWorld();
        world.setGrid(grid);
        int q, e = 0, f = 1;
        int g = 0, z = 1, w = 2, r = 0;

        for (int len = 0; len < Organism.testAlleles.length * 3; len++) {
            counts.add(new Count());
            System.out.println(len);
        }

        for (q = 0; q < (Organism.testAlleles.length * 3); q += 3) {

            System.out.println("g = " + g + ", z = " + z + ", w = " + w);

            counts.get(g).name = "" + Organism.testAlleles[r].charAt(e) + Organism.testAlleles[r].charAt(e);
            //GUI.remAppend(counts.get(g).name);

            counts.get(z).name = "" + Organism.testAlleles[r].charAt(f) + Organism.testAlleles[r].charAt(f);
            //GUI.remAppend(counts.get(z).name);

            counts.get(w).name = "" + Organism.testAlleles[r].charAt(e) + Organism.testAlleles[r].charAt(f);
            //GUI.remAppend(counts.get(w).name);

            g = g + 3;
            z = z + 3;
            w = w + 3;
            r++;
        }

        for (int n = 0; n < orgList.size(); n++) {
            Organism org = (Organism) orgList.get(n);
            Rock rock = new Rock();
            world.add(org);
            world.add(rock);
        }
        
        for (int n = 0; n < orgList.size() / 4; n++) {
            world.add(new Rock());
        }

        world.show();
        Polypeptide.newAminoWindow();



    }//main
}
