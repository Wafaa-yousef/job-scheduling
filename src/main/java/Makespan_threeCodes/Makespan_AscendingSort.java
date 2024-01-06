
package Makespan_threeCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author wafaa
 * 
 */
public class Makespan_AscendingSort {

    public static void main(String[] args) {
    	Scanner input=new Scanner(System.in);
    	
       	System.out.println("input number of jobs");
        int numJobs=input.nextInt();
        
        
        System.out.println("input number of machines:");
        int numMachines=input.nextInt();
        
        ArrayList<Integer> jobsArray= new  ArrayList<>(numJobs);
         String reply;
              System.out.println("Do you want Random values or not ?\n input yes or no");
            do
            {
          
                reply =input.next();
               if(reply.equals("yes"))
               {
                   Random r=new Random();
                   for(int i=0;i<numJobs;i++)
                   {
                      int a=r.nextInt(100);
                          jobsArray.add(a);

                   }
               }
               else if(reply.equals("no"))
                       for(int i=0;i<numJobs;i++)
                       {
                       System.out.println("input job number: "+Integer.toString(i+1));

                       int a=input.nextInt();
                       jobsArray.add(a);

                       }

               else System.out.println("please input reply again");
            }
            while(!(reply.equals("yes"))&&!(reply.equals("no"))); 

            System.out.println("jobs of input are:");
            for(int i=0;i<numJobs;i++)
                System.out.print(jobsArray.get(i)+" ");
            
            System.out.println("");

            ArrayList<Integer> machinesArray= new  ArrayList(numMachines) ;

            for(int i=0;i<numMachines;i++) 
            {
                    int a=0;
                    machinesArray.add(a);
            }
            //sorting jobs Ascendingly
            Collections.sort(jobsArray); 
            
            for(int i=0;i<numJobs;i++) 
            {
                machinesArray.set(0,jobsArray.get(i)+machinesArray.get(0));
                  Collections.sort(machinesArray);

            }
            int mx=machinesArray.get(numMachines-1);
            System.out.println("makespan is:"+mx);
    }
}

