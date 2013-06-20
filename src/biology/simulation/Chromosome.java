/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.simulation;
import biology.Alleles.Colours.BodyColour.*;
import biology.Alleles.Colours.Colour;
import biology.Alleles.NumberOfLegs.Legs;
import biology.simulation.BiologySimulation;
import java.awt.Color;
import java.util.*;
/**
 *
 * @author Willew 
 */
public class Chromosome implements Gene 
{
    public ArrayList<Allele> DNA;
    public Colour colTest = new Colour();
    public Colour blue = new Blue();
    public Colour red = new Red();
    Legs legnum = new Legs();
    Legs legs6 = new Legs();
    Legs egs = new Legs();
    int x, y;
    Object[][] test = {
        {colTest,red,blue},
        {legnum}
    
    };
    
    
    public Chromosome()
    {
       this.DNA = new ArrayList<>();//Object DNA; resolve all issues beforehand
    }
    
    public ArrayList<Allele> newGenomes()
    {
        ArrayList<Allele> genes = new ArrayList<>();
        int ran = (int)Math.round(Math.random()+1);
        for(int n = 0; n < test.length; n++)
        {
            genes.add(null);        
        }
        return genes;
    }
     
    public Chromosome newChromosome(ArrayList<Allele> genes)
    {
      Chromosome cr = new Chromosome();
      for(int n = 0; n < genes.size(); n++)
      {
          cr.DNA.add(genes.get(n));
      }
      return cr;
    }
}
