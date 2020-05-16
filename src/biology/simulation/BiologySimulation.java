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

* @author Will

*/

public class BiologySimulation {

   /**

    * @param args the command line arguments

    */

   static String in1;

   public static int orgCount;
   public static ActorWorld world;
   public static String [] testAlleles = {"Aa", "Ii", "Nn"};
   //what is the breakdown for the math behind these numbers? I can assume we halve the allesles because we're isolating single characters
   public static Count[] counts = new Count[(testAlleles.length*2) +(testAlleles.length/2)];
   public static void main(String[] args) {
       // TODO code application logic here
       //SplashScreen.newSplash();
       //Splasher.createAndShowGUI();
       
	   
       //GUI gui = new GUI();
	   // An easier Solution would be to map Separate count objects to a single gene object when initialized. Versus this... Thing
       int e = 0, f = 1;
       for(int q = 0; q < testAlleles.length; q+=1)
       {
           int z = q+1;
           int w = q+2;
           counts[q] = new Count();
           counts[q].name = ""+testAlleles[q].charAt(e)+testAlleles[q].charAt(e);
           GUI.remAppend(counts[q].name);
           counts[z] = new Count();
           counts[z].name = ""+testAlleles[q].charAt(f)+testAlleles[q].charAt(f);
           GUI.remAppend(counts[z].name);
           counts[w] = new Count();
           counts[w].name = ""+testAlleles[q].charAt(e)+testAlleles[q].charAt(f);
           GUI.remAppend(counts[w].name);
       }
       
       ArrayList<Organism> orgList = Organism.newMetricTonOfOrganisms(10);
       BoundedGrid grid = new BoundedGrid(13, 13);
       world = new ActorWorld();
       world.setGrid(grid);

       /*iterating over alleles and Giving them out at random. 
        * The key issue is that the alleles are not seperate Objects, and this is only taking in a single string and breaking that down
        */

       for(int n = 0; n < orgList.size(); n++)

       {
           Organism org = (Organism)orgList.get(n);
           Rock rock = new Rock();
           world.add(org);
           world.add(rock);
           if ((n % 4) == 0)
        	   world.add(new Rock());
       }
       world.show();

   }//main

}

