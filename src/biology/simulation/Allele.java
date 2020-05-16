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
    public int num, id,alleleID;//Id indicates ehether or not the individual gene is a Homozygous dominant(1)/recessive(-1) or Heterozygous(0) 
    double doub;
    String name,allelename ;
    ArrayList<Allele> genes = new ArrayList();
    public Allele()
    {
        this.name = "Default";
        this.num = 0;
        this.doub = 0.0;
        this.allelename = "DefaultAllele";
        this.id = 0;
        this.alleleID = -1;
    }
    
}
