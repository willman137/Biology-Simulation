/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package biology.misc;

/*
 * SplashDemo.java
 *
 */
import javax.swing.JWindow;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class SplashScreen extends JWindow {

    public String path = "C:/Users/Will/Desktop/All my things/";
    public String[] file = {"loading.jpg"};
    public int id;
    Image img;
    ImageIcon imgicon;
    int slp = 4000;
    public SplashScreen() {
        this.id = 0;
        int ran = (int) (Math.random()*file.length);
        if(ran == file.length)
            ran = file.length-1;
        img = Toolkit.getDefaultToolkit().getImage("C:/Users/Will/Desktop/All my things/" + "loading.jpg"); // here
        imgicon = new ImageIcon(img);
        try {
            setSize(img.getWidth(rootPane),img.getHeight(rootPane));
            setLocationRelativeTo(null);
            show();
            Thread.sleep(slp);
            dispose();
        } catch (Exception exception) {
            javax.swing.JOptionPane.showMessageDialog((java.awt.Component) null, "Error" + exception.getMessage(), "Error:",
                    javax.swing.JOptionPane.DEFAULT_OPTION);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }

    public static void newSplash() {
        SplashScreen sp = new SplashScreen();
    }
}
