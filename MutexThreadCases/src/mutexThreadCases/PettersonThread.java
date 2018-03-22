package mutexThreadCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Charis
 */
public class PettersonThread extends Thread{
    
    private static volatile int turn;
    private volatile boolean[] lock;
    private final int lockValue;
    private final int turnValue;
    
    @Override
    public void run(){
        while(true){
            System.out.println("Thread " + this.getId() + ": Executing the logic before critical section.");
            lock[lockValue] = true;
            turn = turnValue;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(PettersonThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Thread " + this.getId() + ": Trying to enter critical section...");
            while(lock[lockValue] && turn == turnValue){

            }
            
            System.out.println("        Thread " + this.getId() + ": Is in critical section.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(PettersonThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("        Thread " + this.getId() + ": Exiting critical section.");
            lock[lockValue] = false;

            System.out.println("Thread " + this.getId() + ": Executing the logic after critical section.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(PettersonThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public PettersonThread(int id){
        this.lock = new boolean[2];
        this.lockValue = id;
        if(id == 1){
            this.turnValue = 0;
        }
        else{
            this.turnValue = 1;
        }
    }

}
