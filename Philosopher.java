package DiningPhilosophers;

import java.util.concurrent.*; 
import java.util.logging.Level; 
import java.util.logging.Logger; 

public class Philosopher implements Runnable{

    private int id; 
    Semaphore mutex = new Semaphore(1); 
    SleepUtilities S = new SleepUtilities(); 
    
    Philosopher(int id){ 
        this.id = id; 
    } 

    private void eat(){ 
        S.takeNap(); 
    } 

    private void think(){ 
        S.takeNap(); 
    } 

     public void Sleep(){ 
        System.out.println("Philosopher " + (id+1) + " will take a nap for 5 seconds"); 
        S.takeNap(); 
    } 

    // philosophers alternate between thinking and eating
    public void run() {
        while(true){ 
            try { 
                mutex.acquire(); 
            }catch (InterruptedException ex) { 
                Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null,ex);
            } 
            
            // Pick up the forks
            takeForks(id);  

            mutex.release(); 

            eat();        

           try { 
                mutex.acquire(); 
            } catch (InterruptedException ex) { 
                Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
           } 
            
            // put Down the forks
            returnForks(id);                       

            mutex.release(); 

            think();                                   

            Sleep();  

            System.out.println("Philosopher " + (id+1) + " finish his nap"); 
       } 

    }  
  
}
