/*
 * Created on May 10, 2018
 *
 */
package music;

public class Synchronizer {
    
   // private boolean firstVoiceFlag;
	private int brojac = 0; 

    public Synchronizer(int brojac) {
        super();
        this.brojac = brojac;
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
        System.out.println(lyrics);
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

