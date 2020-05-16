/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.simulation;

import biology.simulation.Gene;
import java.util.ArrayList;

/**
 *
 * @author Will
 */
public class Allele implements Gene 
{
    public int num, id,alleleID;//Id indicates whether or not the individual gene is a Homozygous dominant(1)/recessive(-1) or Heterozygous(0) This can be calculated via math directly from the sum of the Ascii int
    double doub;
    String sequence, name, allelename;
    ArrayList<Allele> genes = new ArrayList<Allele>();
    
    public Allele(String Sequence)
    {
    	this.sequence = Sequence;
        this.name = "Default";
        this.num = 0;
        this.doub = 0.0;
        this.allelename = "DefaultAllele";
        this.id = 0;
        this.alleleID = -1;
        this.CountPermutations
    }
    
}
