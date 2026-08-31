######################################################################
# Write your code here
import sys
#import resource
#resource.setrlimit(resource.RLIMIT_STACK, [0x10000000, resource.RLIM_INFINITY])
#sys.setrecursionlimit(0x100000)
# Write your code here
# For getting input from input.txt file 
# sys.stdin = open('input.txt', 'r')  
# Printing the Output to output.txt file 
# sys.stdout = open('output.txt', 'w')
RI =   lambda : [int(x) for x in sys.stdin.readline().strip().split()]
rw =   lambda : sys.stdin.readline().strip().split()
ri =   lambda : int(sys.stdin.readline().strip())
rs =   lambda : sys.stdin.readline().strip()
from collections import defaultdict as df
#import heapq 
#heapq.heapify(li) heappush(li,4) heappop(li)
#import random
#random.shuffle(list)
#infinite = float('inf')
#######################################################################
# from queue import PriorityQueue as pq
from math import *

t = ri()
for _ in range(t):
    n,m = RI()
    a = RI()
    b = RI()

    c = df(int)
    d = df(int)
    for i in a:
        c[i]=1
    for i  in b:
        d[i]=1
    
    flag = 0
    for i in range(1,1001):
        if(d[i]==1 and c[i]==1):
            print("YES")
            print(1,i)
            flag = 1
            break
    if(flag==0):
        print("NO")