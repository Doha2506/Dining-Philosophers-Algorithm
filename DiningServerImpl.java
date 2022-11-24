package DiningPhilosophers;

import java.util.concurrent.*; 
import java.util.concurrent.locks.Condition; 
import java.util.logging.Level; 
import java.util.logging.Logger; 

public class DiningServerImpl implements DiningServer{
    // different philosopher states
    enum State {
        THINKING, HUNGRY, EATING
    };

    // number of philosophers
    public static final int NUM_OF_PHILS = 5;

    // array to record each philosopher's state
    private State[] state;

    public DiningServerImpl() {
        for(int i=0;i<5;i++) 
            state[i] = State.THINKING; 
    }

    // called by a philosopher when they wish to eat 
    @Override
    public void takeForks(int pnum) {
        state[i] = State.HUNGRY; 
        System.out.println("Pick up -----------------------"); 
        System.out.println("Hungry philosopher " + (i+1) + " is trying to pickup sticks"); 
        
        try{ 
            test(i); 
        }catch(NullPointerException ex){} 

        System.out.println("Philosopher " + (i+1) +" is state " + state[i]); 

        if(state[i] != State.EATING){ 
            System.out.println("Hungry Philosopher "+ (i+1) + " was told to wait!"); 
            try { 
                self[i].wait(); 
            } catch (InterruptedException ex) { 
                Logger.getLogger(DiningServerImpl.class.getName()).log(Level.SEVERE, null, ex); 
            } 
        }  
    }

    // called by a philosopher when they are finished eating 
    @Override
    public void returnForks(int pnum) {
        state[i] = State.THINKING; 
        System.out.println("Put Down----------------"); 
        System.out.println("Philosopher " + (i+1) + " is state " + state[i]); 

        // test left and right neighbors 
        test((i + 4) % 5);  
        test((i + 1) % 5); 
    }
    
    private void test(int i){ 
        System.out.println("Test ---------------"); 
        System.out.println("Left Philosopher "+ ((i+4)%5+1) +" state is " + state[(i+4)%5]); 
        System.out.println("Right Philosopher "+ ((i+1)%5+1) +" state is " + state[(i+1)%5]); 
        System.out.println("Current Philosopher " + (i+1) + " state is " + state[i]); 

        // if my left and right neighbor are not eating and i am hungry  
        if ((state[(i + 4) % 5] != State.EATING) && (state[(i + 1) % 5] != State.EATING) 
           &&(state[i] == State.HUNGRY)){  

            state[i] = State.EATING; 
            System.out.println("Current state philosopher " + (i+1) +" now is " + state[i]); 
            self[i].signal(); 
        } 
    } 
    
    
}
