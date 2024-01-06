package Codes_with_UserInterfaces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// A class to store a Job

public class weightedActivityCode
{
    static class Job
    {
	int start, finish, profit;

	public Job(int start, int finish, int profit)
	{
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}


    }
   
   
	// Function to find the index of the last job which doesn't conflict with the
	// given job. It performs a linear search on the given list of jobs.
	public static int findLastNonConflictingJob(List<Job> jobs, int n)
	{
		// find the last job index whose finish time is less than or equal to the
		// given job's start time
		for (int i = n - 1; i >= 0; i--)
		{
			if (jobs.get(i).finish <= jobs.get(n).start) {
				return i;
                                                                     }
		}

		// return the negative index if no non-conflicting job is found
		return -1;
	}
       
      
        
    

	// Function to find the maximum profit of non-overlapping jobs using DP
	public static int findMaxProfit(List<Job> jobs,int[]check)
	{
            
		// sort jobs in increasing order of their finish times
		Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

		// get the number of jobs
		int n = jobs.size();
              int[] maxProfit = new int[n];
		// base case
		if (n == 0) {
			return 0;
                            }

		// construct a lookup table where the i'th index stores the maximum profit
		// for the first `i` jobs
		
		// maximum profit gained by including the first job
		maxProfit[0] = jobs.get(0).profit;
               check[0]=1;

		// fill the `maxProfit[]` table in a bottom-up manner from the second index
		for (int i = 1; i < n; i++)
		{ 
                    
			// find the index of the last non-conflicting job with the current job
			int index = findLastNonConflictingJob(jobs, i);
                      
			// include the current job with its non-conflicting jobs
			int incl = jobs.get(i).profit;
                       
			if (index != -1) {
				incl += maxProfit[index];
                                          }
                        // checking if currently element belongs to the solution
                        if(Math.max(incl, maxProfit[i - 1])==incl)
                           check[i]=1; else check[i]=0;
                        
                       
			// store the maximum profit by including or excluding the current job
			maxProfit[i] = Math.max(incl, maxProfit[i - 1]); 
  
		}

		// return maximum profit
              
		return maxProfit[n - 1];
	}

	public static void main(String[] args)
	{
                
            Scanner in=new Scanner(System.in);
            System.out.println("input number of jobs");
            int n=in.nextInt();
            //define list of jobs
            List<Job> jobs=new ArrayList<>(); 
             // define array to follow selected jobs
            int[] check =new int[n]; 

            String reply;
              System.out.println("Do you want Random values or not ?\n input yes or no");
            do
            {
          
                reply =in.next();
                //random input
               if(reply.equals("yes"))
               {
                   Random r=new Random();
                   for(int i=0;i<n;i++)
                    {
                        int s=r.nextInt(10);
                        int f=r.nextInt(10)+s+1;
                        int w=r.nextInt(10)+10;
                        jobs.add(new Job(s,f,w));
                    }
               }
               // manual input
               else if(reply.equals("no"))
                       for(int i=0;i<n;i++)
                           {   
                               System.out.println("input job number: "+Integer.toString(i+1));
                               int s=in.nextInt();
                               int f=in.nextInt();
                               int w=in.nextInt(); 
                               jobs.add(new Job(s,f,w));
                           }
               else System.out.println("invalaid input ,please input reply again");
            }
            while(!(reply.equals("yes"))&&!(reply.equals("no")));
                    
            
            System.out.println("jobs of input is :");
            for(int i=0;i<n;i++)
               System.out.println("("+jobs.get(i).start+","+jobs.get(i).finish+","+jobs.get(i).profit+")"); 
            // result is the optimal solution
           int result=findMaxProfit(jobs,check); 
           System.out.println("Max profit is:");
           System.out.println(result);
           
           System.out.println("Selected jobs are :");

            //fininding index of last element in solution set
            int lastIncludedElement=-1;
            for(int i=n-1;i>=0;i--)
                    if (check[i]==1){
                       lastIncludedElement=i;
                       break; 
                                    }
             // printing the last element in solution set                        }
            System.out.println("("+jobs.get(lastIncludedElement).start+","+jobs.get(lastIncludedElement).finish+","+jobs.get(lastIncludedElement).profit+")");
             // printing elements of solution
            for(int i=lastIncludedElement;i>=0;i--)
                if(check[i]==1)
                if (jobs.get(i).finish<=jobs.get(lastIncludedElement).start){
                      System.out.println("("+jobs.get(i).start+","+jobs.get(i).finish+","+jobs.get(i).profit+")");  
                    
                      lastIncludedElement=i;
                                                                             }
           
        }
}
        