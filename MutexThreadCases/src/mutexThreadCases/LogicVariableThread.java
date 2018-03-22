package mutexThreadCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Charis
 */
public class LogicVariableThread extends Thread{
    
    private static volatile boolean lock;
    
    @Override
    public void run(){
        while(true){
            System.out.println("Thread " + this.getId() + ": Executing the logic before critical section.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(LogicVariableThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Thread " + this.getId() + ": Trying to enter critical section...");
            while(lock){

            }
            lock = true;
            System.out.println("        Thread " + this.getId() + ": Is in critical section.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(LogicVariableThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("        Thread " + this.getId() + ": Exiting critical section.");
            lock = false;

            System.out.println("Thread " + this.getId() + ": Executing the logic after critical section.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(LogicVariableThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
