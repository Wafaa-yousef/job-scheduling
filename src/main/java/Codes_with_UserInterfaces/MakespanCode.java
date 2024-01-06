/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Codes_with_UserInterfaces;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author wafaa
 * 
 */
public class MakespanCode {

    public static void main(String[] args) {
    	Scanner input=new Scanner(System.in);
    	System.out.println("input number of jobs");
        int numJobs=input.nextInt();
        System.out.println("input number of machines:");
        int numMachines=input.nextInt();
        
        ArrayList<Integer> jobsArray= new  ArrayList  <Integer>(numJobs);
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
        else System.out.println("invalaid input , please input reply again");
        }
        while(!(reply.equals("yes"))&&!(reply.equals("no"))); 

        System.out.println("jobs of input are:");
        for(int i=0;i<numJobs;i++)
            System.out.print(jobsArray.get(i)+" ");
        
        System.out.println("");
        
        ArrayList<Integer> machinesArray = new ArrayList<Integer>(numMachines) ;
        //initializing Machiens' array with zero values
        for(int i=0;i<numMachines;i++) 
        {
        	int a=0;
        	machinesArray.add(a);
        }
       
        // sorting jobs decendingly
        Collections.sort(jobsArray);
        Collections.reverse(jobsArray);
         // calcutating makespan
        for(int i=0;i<numJobs;i++) 
        {
            machinesArray.set(0,jobsArray.get(i)+machinesArray.get(0));
            Collections.sort(machinesArray);
        }
 	   System.out.println("Makespan is "+machinesArray.get(numMachines-1));
    }
            }

