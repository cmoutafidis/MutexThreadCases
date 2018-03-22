package mutexThreadCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Charis
 */
public class SwitchingThreads extends Thread{
    
    private static int numberOfThreads;
    private static volatile int currentThread;
    private final int threadID;
    
    @Override
    public void run(){
        while(true){
            System.out.println("Thread " + this.getId() + ": Executing the logic before critical section.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(SwitchingThreads.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Thread " + this.getId() + ": Trying to enter critical section...");
            while(currentThread != threadID){

            }
            
            System.out.println("        Thread " + this.getId() + ": Is in critical section.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(SwitchingThreads.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("        Thread " + this.getId() + ": Exiting critical section.");
            currentThread = (currentThread + 1) % numberOfThreads;

            System.out.println("Thread " + this.getId() + ": Executing the logic after critical section.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(SwitchingThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public SwitchingThreads(int id){
        this.threadID = id;
    }
    
    public static void setNumberOfThreads(int threads){
        SwitchingThreads.numberOfThreads = threads;
    }

}
