package DiningPhilosophers;

public class DiningPhilosophers {

    public static void main(String args[]) {

        Philosopher p1 = new Philosopher(0); 
        Thread t1 = new Thread(p1); 

        Philosopher p2 = new Philosopher(1); 
        Thread t2 = new Thread(p2); 

        Philosopher p3 = new Philosopher(2); 
        Thread t3 = new Thread(p3); 

        Philosopher p4 = new Philosopher(3); 
        Thread t4 = new Thread(p4);

        Philosopher p5 = new Philosopher(4); 
        Thread t5 = new Thread(p5); 

        t1.start(); 
        t2.start(); 
        t3.start(); 
        t4.start(); 
        t5.start(); 
    }
}
