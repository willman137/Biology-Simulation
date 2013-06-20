/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.simulation;
import biology.Organisms.Organism;
import info.gridworld.actor.Rock;

/**

*

* @author student

*/

public class Grave extends Rock {
   public int generation, chronos;
   public String name, gender, diet, genotype;
   
   public Grave(Organism organism) {
       this.generation = organism.generation;
       this.name = organism.name;
       this.gender = organism.gender;
       this.diet = organism.diet;
       this.genotype = organism.genotype;
       this.chronos = (int) (Math.random() * (organism.age/2));

   }

   @Override

   public void act() {

       this.chronos = chronos - 1;

       if (this.chronos <= 0){

           this.removeSelfFromGrid();

       }

   }

   public StringBuffer getInfo() {

       StringBuffer sb = new StringBuffer();

       sb.append(("Name: " + this.name + "\n"));

       sb.append(("Gender: " + this.gender + "\n"));

       sb.append(("Diet: " + this.diet + "\n"));

       sb.append(("Genotype: " + this.genotype + "\n"));

       sb.append(("Generation: " + this.generation + "\n"));

       sb.append(("Time till Disappearance: " + this.chronos + "\n"));

       GUI.remAppend(sb.toString());
       return sb;

   }   

   public int getChronos() {

       return this.chronos;

   }

}

