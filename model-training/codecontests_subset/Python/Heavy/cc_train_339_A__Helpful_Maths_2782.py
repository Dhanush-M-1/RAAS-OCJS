######################################################################
# Write your code here
import sys
from math import *
input = sys.stdin.readline
#import resource
#resource.setrlimit(resource.RLIMIT_STACK, [0x10000000, resource.RLIM_INFINITY])
#sys.setrecursionlimit(0x100000)
# Write your code here
RI = lambda : [int(x) for x in sys.stdin.readline().strip().split()]
rw = lambda : input().strip().split()
from collections import defaultdict as df
import heapq 
#heapq.heapify(li) heappush(li,4) heappop(li)
#import random
#random.shuffle(list)
infinite = float('inf')
#######################################################################
 
s=input().strip()
l=[]
for i in range(0,len(s),2):
    l.append(s[i])

l.sort()

for i in range(0,len(l)-1):
    print(l[i],end="")
    print("+",end="")
print(l[len(l)-1])
    
