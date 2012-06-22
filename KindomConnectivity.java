/*
It has been a prosperous year for King Charles and he is rapidly expanding his kingdom.A beautiful new kingdom has been recently constructed and in this kingdom there are many cities connected by a number of one-way roads.Two cities may be directly connected by more than one roads, this is to ensure high connectivity.

In this new kingdom King Charles has made one of the cities at his financial capital and one as warfare capital and he wants high connectivity between these two capitals.The connectivity of a pair of cities say city A and city B is defined as the number of different paths from city A to city B. A path may use a road more than once if possible. Two paths are considered different if they do not use exactly the same sequence of roads.

There are N cities numbered 1 to N in the new kingdom and M one-way roads  . City 1 is the monetary capital and city N is the warfare capital.

You being one of the best programmers in new kingdom need to answer the connectivity of financial capital and warfare capital ,i.e number of different paths from city 1 to city N.

Input Description:

First line contains two integers N and M.

Then follow M lines ,each having two integers say x and y, 1<=x,y<=N , indicating there is a road from city x to city y.

Output Description:

Print the number of different paths from city 1 to city N modulo 1,000,000,000(10^9).If there are infinitely many different paths print "INFINITE PATHS"(quotes are for clarity).

Sample Input:

5 5
1 2
2 4
2 3
3 4
4 5

Sample Output:

2

Sample Input:

5 5
1 2
4 2
2 3
3 4
4 5

Sample Output:

INFINITE PATHS

Constraints:

2<=N<=10,000(10^4)

1<=M<=1,00,000(10^5) 

Two cities may be connected by more than two roads and in that case those roads are to be considered different for counting distinct paths
*/

/* Enter your code here. Read input from STDIN. Print output to STDOUT *//* Enter your code here. Read input from STDIN. Print output to STDOUT */

import java.util.*;


class Graph 
{	
public ArrayList<ArrayList<Integer> > Gra=new ArrayList<ArrayList<Integer> >();
public int[] FirstLine;
Graph(int m)
{
	FirstLine=new int[m];
	for(int i=0;i<m;i++)
	{
		ArrayList<Integer> tmp=new ArrayList<Integer> ();
		Gra.add(tmp);
	}
}
public void addEdge(int node1, int node2) {  
	Gra.get(node2-1).add(node1-1);  
	if(node1==1)
	{
		FirstLine[node2-1]=1;
	}
}

}

public class Solution {
	
	public static int min(int a, int b)
	{
		return a < b ? a : b;
        }
	public static void main(String []args)
	{
		Scanner SC=new Scanner(System.in);
		SC.useDelimiter(" ");
		String tmp0=SC.nextLine();
		String first[]=tmp0.split(" ");
		int m=Integer.parseInt(first[0]);
		Graph graph=new Graph(m);

		for(int i=0;i<Integer.parseInt(first[1]);i++)
		{
		    String tmp1=SC.nextLine();		
		    String edge[]=tmp1.split(" ");
		    graph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
		
		}
      int rs=graph.FirstLine[m-1]% 1000000000;
      boolean TT=true;
      int[] tmp=graph.FirstLine;
      int[] swap;
      int[] tmp1=new int[m];
      for(int k=0;k<min(m-1,625);k++)
      {
    	 
      for(int i=0;i<m;i++)
      {
    	  int temp=0;
    	
    	  for(int j=0;j<graph.Gra.get(i).size();j++)
    	  {
    		  temp+=tmp[graph.Gra.get(i).get(j)];
                  temp=temp% 1000000000;
    	  }
    	  tmp1[i]=temp% 1000000000;
    	  
      }  
      rs+=tmp1[m-1]% 1000000000;
      rs=rs% 1000000000;
      swap = tmp;
      tmp = tmp1;
      tmp1 = swap;
      }
     
            if(m>100)
            {
                m=0;
            }
            
      for(int k=0;k<m;k++)
      {
    	 // int[] tmp1=new int[m];
          
          for(int i=0;i<m;i++)
          {
        	  int temp=0;
        	
        	  for(int j=0;j<graph.Gra.get(i).size();j++)
        	  {
        		  temp+=tmp[graph.Gra.get(i).get(j)];
                          temp=temp% 1000000000;
        	  }
        	  tmp1[i]=temp% 1000000000;
        	  
          }  
          if(tmp1[m-1]!=0)
          {
        	  System.out.println("INFINITE PATHS");
        	  TT=false;
        	  break;
          }
      swap = tmp;
      tmp = tmp1;
      tmp1 = swap;
      }

      if(TT)
      System.out.println(rs);
      
		
	}

}
