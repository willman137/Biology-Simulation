/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.Alleles.Colours.BodyColour;

import biology.Alleles.Colours.Colour;
import biology.simulation.Gene;

/**
 *
 * @author Will
 */
public class Blue extends Colour implements Gene{
    public Blue()
    {
        r = 0;
        g = 0;
        b = 256;
        this.alleleID = -1;
    }
    
}
