/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biology.simulation;

import biology.Organisms.Organism;
import biology.Organisms.Reaper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import java.util.Scanner;
import java.util.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.JPopupMenu;

/**
 *
 * @author Will
 */
public class GUI extends JFrame implements EventListener {

    public static String pub;
    public static int qr = 0;
    public static boolean state = false;

    public GUI()//try to fix the menuBar error(no sub menus)
    {
        boolean isVisible = true, canEdit = false;
        int fx = 400, fy = 400;
        JFrame frame = new JFrame();
        JMenuBar menubar = new JMenuBar();

        JMenu _new = new JMenu("New");
        JMenuItem meg = new JMenuItem("Megrez");
        JMenuItem organ = new JMenuItem("Organism");
        JMenuItem reaper = new JMenuItem("Reaper");


        _new.add(organ);
        _new.add(meg);
        _new.add(reaper);
        menubar.add(_new);

        frame.setSize(fx, fy);
        frame.getContentPane().add(BorderLayout.NORTH, menubar);
        frame.getContentPane().add(BorderLayout.CENTER, tArea);

        GUI.remAppend("Welcome to Terminal Dogma\n");
        tArea.setEditable(canEdit);

        frame.setLocation(650, 20);
        frame.setDefaultCloseOperation(3);

        organ.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent b1) {
                GUI.remAppend("Humph");
                BiologySimulation.world.add(BiologySimulation.world.getRandomEmptyLocation(), new Organism());
                BiologySimulation.world.show();
            }
        });

        reaper.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent b1) {
                if(Reaper.isPresent != true){
                GUI.remAppend("Death Approaches...");
                Reaper reaper = new Reaper();
                reaper.setMaxKills();
                BiologySimulation.world.add(BiologySimulation.world.getRandomEmptyLocation(),reaper );
                BiologySimulation.world.show();
            }
                else
                    GUI.remAppend("Death Is already Present");
            }
        });

        DefaultCaret caret = (DefaultCaret) tArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        frame.add(new JScrollPane(tArea), BorderLayout.CENTER);

        frame.setVisible(isVisible);

    }
    //587-352-9199
    

    
    public static void startSplash() {
        JProgressBar progBar = new JProgressBar();
        JOptionPane.showMessageDialog(progBar, "Now Loading..");

    }

    public static void setScrollPane(JTextArea area51) {
        // We put the TextArea object in a Scrollable Pane
        final JTextArea area = area51;
        sArea = new JScrollPane(area);

        // Lines will be wrapped if they are too long to fit within the 
        // allocated width
        area.setLineWrap(true);

        // Lines will be wrapped at word boundaries (whitespace) if they are 
        // too long to fit within the allocated width
        area.setWrapStyleWord(true);

        // Assuming this is the chat client's window where we read text sent out 
        // and received, we don't want our Text Area to be editable!
        area.setEditable(false);

        // We also want a vertical scroll bar on our pane, as text is added to it
        sArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Now let's just add a Text Field for user input, and make sure our 
        // text area stays on the last line as subsequent lines are 

    }

    public static JPopupMenu newAlert() {
        JPopupMenu pMenu = new JPopupMenu("Dojima");
        pMenu.setPopupSize(400, 200);
        pMenu.setVisible(true);
        return pMenu;
    }

    public static void remAppend(String foo) {
        tArea.append(">> " + foo + "\n");
        tArea.setCaretPosition(tArea.getDocument().getLength());
    }

    public static void remAppend(int foo) {
        tArea.append(">> " + foo + "\n");
        tArea.setCaretPosition(tArea.getDocument().getLength());
    }

    public static JFrame newWindow(int length, int height) {
        int fx, fy;
        fx = length;
        fy = height;
        JFrame frame = new JFrame();
        frame.setSize(fx, fy);
        return frame;
    }

    public static JFrame newMegrezTermWindow() {
        int fx = 400, fy = 400;
        boolean isVisible = true;
        JFrame term = new JFrame();
        JTextArea t_Area = new JTextArea();
        t_Area.setEditable(false);
        t_Area.append("Megrez Terminal\n");
        term.setSize(fx, fy);
        term.getContentPane().add(BorderLayout.CENTER, t_Area);


        term.setDefaultCloseOperation(3);
        term.setVisible(isVisible);
        return term;

    }
    public static JTextArea tArea = new JTextArea();
    public static JScrollPane sArea;


}
