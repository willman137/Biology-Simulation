/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.Alleles.Colours.BodyColour;
import biology.Alleles.Colours.Colour;
import java.util.ArrayList;
import biology.simulation.Gene;
/**
 *
 * @author Will
 */
public class Red extends Colour implements Gene
{
    public Red()
    {
        r = 256;
        g = 0;
        b = 0;
        this.alleleID = 1;
    }

}
