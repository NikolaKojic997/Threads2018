/*
 * Created on May 10, 2018
 *
 */
package music;

import javax.swing.JTextPane;

public class Synchronizer {
    
   
	private int brojac = 0;
	private JTextPane textPane; 

    public Synchronizer(int brojac, JTextPane textPane) {
        super();
        this.brojac = brojac;
        this.textPane = textPane;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (brojac !=0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singSecondVoice(String lyrics, int delay) {
        while (brojac != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singThirdVoice(String lyrics, int delay) {
        while (brojac != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    private void sing(String lyrics, int delay) {
        textPane.setText(""+textPane.getText() + lyrics +'\n');
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        brojac = (brojac+1)%3;
        notifyAll();
    }

}

