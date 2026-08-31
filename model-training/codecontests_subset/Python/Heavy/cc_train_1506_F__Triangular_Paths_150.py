import queue
import math
import sys
from collections import deque 

def path_exists (node1, node2):
    r1,c1 = node1
    r2,c2 = node2

    #assert (r1 >=1 and c1 in range (1,r1+1) )
    #assert (r2 >=1 and c2 in range (1,r2+1) )
    
    return (r1 in range (1,r2+1) and  c2 in range (c1,c1+r2-r1+1))

def min_cost (node1, node2):
    r1,c1 = node1
    r2,c2 = node2
    ans = 0
    
    #if not path_exists (node1, node2):
    #    ans =  math.inf
    
    if c2 == c1: 
        ans = (r2-r1)//2 
        if (r1+c1)%2==1 and (r2-r1) %2==1:
            ans+=1

    
    elif r2-r1 == c2-c1:
        ans = (r2-r1) * int ((r1+c1)%2==0) 
 
    else: 
        r1,c1 = node1
 
        if (r1+c1)%2==0:
            r1 += 1
        r1 = r1+ (c2-c1)
        c1 = c2
        
        
        ## r1+c1 is odd
        ans = (r2-r1)//2 + int ((r2-r1) %2==1)
  
    return ans

t = int(input())
for _ in range(t):
    n = int (input())
    R  = list(map(int,input().split(' ')))
    C  = list(map(int,input().split(' ')))


    nodes= [ (R[i],C[i]) for i in range (n)]
    nodes.sort( key=lambda p: p[0])

    minimum_cost = min_cost ((1,1),nodes[0])

    for j in range (n-1):
        minimum_cost += min_cost (nodes[j],nodes[j+1])

    print (minimum_cost)

