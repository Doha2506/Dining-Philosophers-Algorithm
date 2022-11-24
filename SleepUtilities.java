package DiningPhilosophers;

import java.util.logging.Level; 
import java.util.logging.Logger; 

public class SleepUtilities {
    
    public void takeNap(){ 
        try { 
            Thread.sleep(5000); 
        } catch (InterruptedException ex) { 
            Logger.getLogger(SleepUtilities.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }
    
}
