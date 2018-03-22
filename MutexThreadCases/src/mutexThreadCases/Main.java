package mutexThreadCases;

/**
 *
 * @author Charis
 */
public class Main {

    public static void main(String[] args) {
        
        int threads = 3;
        
//        //LogicVariableThreads
//        for(int i = 0; i < threads; i++){
//            new LogicVariableThread().start();
//        }

//        //SwitchingThreads
//        SwitchingThreads.setNumberOfThreads(threads);
//        for(int i = 0; i < threads; i++){
//            new SwitchingThreads(i).start();
//        }
        
//        //PettersonThread
//        for(int i = 0; i < threads; i++){
//            new PettersonThread(i).start();
//        }
        
        //LamportThread
        LamportThread.setNumberOfThreads(threads);
        LamportThread.initVariables();
        for(int i = 0; i < threads; i++){
            new LamportThread(i).start();
        }
    }
    
}
