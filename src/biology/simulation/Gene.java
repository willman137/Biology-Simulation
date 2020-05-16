/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.simulation;
import biology.misc.Count;
import java.util.*;

/**
 *
 * @author Will
 */
public interface Gene 
{
    public String type = "";
    public Hashtable<String, Count> CountPermutations = null;
}
