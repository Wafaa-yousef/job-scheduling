/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes_with_UserInterfaces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author wafaa
 */
class Job
{
int start, finish;

// Constructor
public Job(int start, int finish)
{
  this.start = start;
  this.finish = finish;
}
}

// class to define user defined comparator
class Compare
{

// A utility function that is used for sorting
// activities according to finish time
static void compare(Job arr[], int n)
{
  Arrays.sort(arr, new Comparator<Job>()
        {
        @Override
        public int compare(Job s1, Job s2)
        {
          return s1.finish - s2.finish;
        }
        });
}
}

// Driver class
public class ActivitySelectionCode {

// Returns count of the maximum set of activities that
// can
// be done by a single person, one at a time.
static ArrayList<Job> MaxActivities(Job arr[], int n)
{
   ArrayList<Job> solution=new ArrayList();
  // Sort jobs according to finish time
  Compare obj = new Compare();
  obj.compare(arr, n);
  
  // The first activity always gets selected
int i=0;
solution.add(new Job(arr[i].start,arr[i].finish));
  // Consider rest of the activities
  for (int j = 1; j < n; j++)
  {
  // If this activity has start time greater than
  // or equal to the finish time of previously
  // selected activity, then select it
  if (arr[j].start >= arr[i].finish)
  {
      solution.add(new Job(arr[j].start,arr[j].finish));
      
       i = j;
  }
  
  }
 
  return solution;
}


public static void main(String[] args)
{
 Scanner input = new Scanner(System.in);
 System.out.println("input number of jobs");
        int n=input.nextInt();
          Job[]  arr = new Job[n];

       String reply;
              System.out.println("Do you want Random values or not ?\n input yes or no");
            do
            {
          
                reply =input.next();
                // random input
                if(reply.equals("yes"))
                {
                    Random r=new Random();
                    for(int i=0;i<n;i++)
                    {
                        int s=r.nextInt(10);
                        int f=r.nextInt(10)+s+1;
                        int w=r.nextInt(10)+10;
                        arr[i]=new Job(s,f);
                    }
                }
                // manual input
                else if(reply.equals("no"))
                        for(int i=0;i<n;i++)
                            {   
                                System.out.println("input job number: "+Integer.toString(i+1));
                                int s=input.nextInt();
                                int f=input.nextInt();
                                int w=input.nextInt(); 
                                arr[i]=new Job(s,f);
                            }
                else System.out.println("invalaid input ,please input reply again");
            }
            while(!(reply.equals("yes"))&&!(reply.equals("no"))); System.out.println("Activities of input are :");
            // print input's jobs
               for(int i=0;i<n;i++)
                   System.out.println("("+arr[i].start+","+arr[i].finish+")");
            // printing jobs of solution
            ArrayList<Job> result=MaxActivities(arr, n);
               System.out.println("selected Activities are: ");
            for(int i=0;i<result.size();i++){
                System.out.print("(" + result.get(i).start + ","
                       + result.get(i).finish + ") ");
            }
   
            }
}    


