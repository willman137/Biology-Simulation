package biology.simulation;
import biology.Alleles.Colours.Colour;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
/**
 *
 * @author Will
 */
public class Polypeptide 
{
    public String acids = "";//for organization purposes: U > C > A > G
    public static String[][] codons = { 
        {"methionine","AUG"},
        {"terminator","UAA","UAG","UGA"},
        {"phenylalanine","UUU","UUC"},
        {"leucine","UUA","UUG","CUU","CUC","CUA","CUG"},
        {"isoleucine","AUU","AUC","AUA"},
        {"serine","UCU","UCC","UCA","UCG","AGU","AGC"},
        {"proline","CCU","CCC","CCA","CCG"},
        {"theronine","ACU","ACC","ACA","ACG"},
        {"alanine","GCU","GCC","GCA","GCG"},
        {"tyrosine","UAU","UAC"},
        {"histidine","CAU","CAC"},
        {"glutamine","CAA","CAG"},
        {"asparagine","AAU","AAC"},
        {"lysine","AAA","AAG"},
        {"asparatate","GAU","GAC"},
        {"glutamate","GAA","GAG"},
        {"cystine","UGU","UGC"},
        {"tryptophan","UGG"},
        {"arginine","CGU","CGC","CGA","CGG","AGA","AGG"},
        {"glycine","GGU","GGC","GGA","GGG"}
    };
    
    public Polypeptide()
    {
        this.acids = "";
    }
    
    public static void newAminoWindow()
    {
       JFrame info = new JFrame("Amino Acid Info");
       text = new JTextArea();
       
       info.setSize(225, 225);
       info.getContentPane().add(BorderLayout.CENTER, text);  
       
       text.setEditable(false);
       
       
       
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Codon");
        final JTextField tf = new JTextField(5);// accepts up to x characters
        JButton send = new JButton("Go");
        panel.add(label);// Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);

       info.getContentPane().add(BorderLayout.SOUTH, panel);
       
       DefaultCaret caret = (DefaultCaret) text.getCaret();
       caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
       info.add(new JScrollPane(text), BorderLayout.CENTER);
       info.setLocation(1050,20);       
       info.show();
    
            send.addActionListener(new ActionListener(){    
            @Override    
            public void actionPerformed(ActionEvent send) {
                //In response to a button click:                        
                String in = tf.getText();
                if(in.equals("")){
                    Polypeptide.appendAminoInfo("");
                }                
                else{
                Polypeptide.appendAminoInfo(Polypeptide.checkAminoAcid(in));
                }
                tf.setText("");
            }//keyA Action
        });//keyA event 
    
    }
    
    public static void appendAminoInfo(String input)
    {
        text.append(input+"\n");
    }
    
    public static String checkAminoAcid(String check)
    {
        
        for(int z = 0; z < codons.length; z++)
        {
            
            for(int w = 1; w < codons[z].length; w++)
            {
                String checking = codons[z][w];
                if(check.equals(checking)){
                    char rep = (char)(codons[z][0].charAt(0)-32);
                    char[] nameChars = codons[z][0].toCharArray();
                    nameChars[0] = (char)(nameChars[0] - 32);
                    
                    String finName = "";
                    for(int q = 0; q < codons[z][0].length(); q++)
                        finName += nameChars[q];
                    return "Your Amino-Acid is "+finName;
                }
            }//for loop "w" 
        
        }//for loop "z"
        return "Not a valid Amino-Acid";
    }
    
    public static JTextArea text;
}
