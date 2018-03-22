
package mutexThreadCases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Charis
 */
public class LamportThread extends Thread{
    
    private static int numberOfThreads;
    private static volatile boolean[] choosing;
    private static volatile int num[];
    private int id;
    
    @Override
    public void run(){
        while(true){
            System.out.println("Thread " + id + ": Executing entry protocol.");
            for(int i = 0; i < num.length; i++){
                while(choosing[i]) {
                    
                }
            }
            choosing[id] = true;
            num[id] = findMax();
            choosing[id] = false;
            
            for(int i = 0; i < num.length; i++){
                while((num[i] > 0) && (num[id] > num[i]) || (num[id] == num[i]) && (i<id)){
                    
                }
            }
            
            System.out.println("        Thread " + id + ": Is being served with number " + num[id]);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(LamportThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Thread " + id + ": Executing exit protocol.");
            num[id] = 0;
        }
    }
    
    public LamportThread(int id){
        this.id = id;
    }
    
    public static void setNumberOfThreads(int number){
        numberOfThreads = number;
    }
    
    public static void initVariables(){
        choosing = new boolean[numberOfThreads];
        num = new int[numberOfThreads];
        
        for(int i = 0; i < numberOfThreads; i++){
            choosing[i] = false;
            num[i] = 0;
        }
    }
    
    public static int findMax(){
        int max = 0;
        for(int i = 0; i < num.length; i++){
            if(num[i]>max){
                max = num[i];
            }
        }
        return max + 1;
    }

}
