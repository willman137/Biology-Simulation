/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.Alleles.NumberOfLegs;
import biology.Alleles.*;
import biology.simulation.Gene;
/**
 *
 * @author Will
 */
	public class Legs implements Gene
	{
		public int legNum;
		public Legs()
                {
                    this.legNum = 0;
                }
		
		public void setNumOfLegs(int num)
                {
                    this.legNum = num;
                }
	}