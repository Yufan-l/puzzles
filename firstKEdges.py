'''
Created on Apr 14, 2012

@author: yliu0


In the country of XIONS there are N cities and M roads. A road directly connects one city to another. The road network was built slowly over time, one road per year. Now, the roads are getting older and have started to break, in the order that they were built.
 
You need to find the number of neighborhoods that remain after the first k roads have broken. A neighborhood is defined as a group of cities such that, a person can go from any city in the group to any other city in the group by using non-broken roads.
 
In concrete terms, for a undirected graph with N nodes and M edges, we want to know how many connected blocks of the Graph remain after deleting the first K edges in the input.
 
Input Format:
First line of the input contains two integers N and M.
Then following M lines each containing 2 space-seperated integers u and v, which denotes an road. These roads were built in this order one after another.
 
Output Format:
Output M lines, the ith line is the number of neighborhoods that remain after first i roads have been broken..
 
Constraints:
0 < N <= 10000
0 < M <= 100000
0 <= u, v < N
No road directly connects a city to itself.
For any pair of cities, there is at most one road which directly connects them.
 
Sample Input:
5 10
0 1
1 2
1 3
1 4
0 2
2 3
0 4
0 3
3 4
2 4
 
Sample Output:
1
1
1
2
2
2
2
3
4
5
 
Explanation:
 
Let us model the network of cities and roads as a graph with cities as nodes and roads as edges in the graph.
 
The network given in the sample input is a complete graph (in this specific case), as each pair of vertices has an edge connecting them, so there's only 1 neighborhood at first. The first 3 lines of output are ones because after deleting the first 3 edges of the graph, all vertices are still connected. But after deleting the first 4 edges of the graph, vertex 1 will be disconnected with other vertices, and it became an independent neighborhood. As you continue deleting edges, the number of disconnected blocks increases, and finally each city will be its own neighborhood: the last output should always be N.

'''
content1=raw_input().strip().split(" ")

node_num=int(content1[0])

edge_num=int(content1[1])

edge=[]

output_list=[]

reference={}

graph={}

set_list=[]

def smaller(a,b):
    if a<b:
        return a
    else:
        return b
    
def larger(a,b):
    if a>b:
        return a
    else:
        return b
      
for i in range(node_num):
    reference[i]=i
    graph[i]=[i]
    

for i in range(edge_num):
    content=raw_input().strip().split(" ")
    tmp=[]
    tmp.append(int(content[0]))
    tmp.append(int(content[1]))
    edge.append(tmp)
        

output_list.append(node_num)

for i in range(edge_num-1):
    if reference[edge[edge_num-1-i][0]]==reference[edge[edge_num-1-i][1]]:
        output_list.append(node_num)
    else:
        small=smaller(reference[edge[edge_num-1-i][0]],reference[edge[edge_num-1-i][1]])
        large=larger(reference[edge[edge_num-1-i][0]],reference[edge[edge_num-1-i][1]])
        node_num-=1
        output_list.append(node_num)
        for i in graph[large]:
            graph[small].append(i)
            reference[i]=small    
   
        
output_list.reverse()

for nodes in output_list:
    print nodes
        

    

