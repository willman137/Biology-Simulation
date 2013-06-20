/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.Alleles.Colours;
import info.gridworld.actor.*;
import biology.simulation.Allele;
import biology.simulation.Gene;
import java.awt.Color;

/**
 *
 * @author Will
 */
public class Colour extends Allele implements Gene{
    
    public static int r,g,b;
    Color  col;
    
    public Colour()
    {
        this.col = new Color(0,0,0);
        this.id = 0;
    }
    
    
}
