/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public  class Work {

  
    private  Random random=new Random();
    private Object lock1=new Object();
     private Object lock2=new Object();
    private  List<Integer> list1=new ArrayList<Integer>();
    private  List<Integer> list2=new ArrayList<Integer>();
    public  void stageOne()
    {
        synchronized(lock1)
        {
          try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
        }
      list1.add(random.nextInt(100));
        }
    }
     public  void stageTwo()
    {
          synchronized(lock2)
        {
          try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
        }
         list2.add(random.nextInt());
        }
    }
      
    
    public void process()
    {
     for(int i=0;i<1000;i++)
     {
      stageOne();
      stageTwo();
     }
    
    }
    public  void main() {
        System.out.println("Starting.....");
        long start=System.currentTimeMillis();
        Thread t1=new Thread(new Runnable() {

            @Override
            public void run() {
                process();
            }
        });
         Thread t2=new Thread(new Runnable() {

            @Override
            public void run() {
                process();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
        }
        long end =System.currentTimeMillis();
        System.out.println("Time take" +(start-end));
        
        
         System.out.println("oneList "+list1.size()+" twoList "+list2.size());
    }

}
