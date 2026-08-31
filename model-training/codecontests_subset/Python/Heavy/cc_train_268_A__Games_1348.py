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

n=int(input())

d={}
l=[]
for i in range(n):
    a,b=RI()
    l.append(a)
    if(b in d):
        d[b]+=1
    else:
        d[b]=1

count=0
for i in range(n):
    if(l[i] in d):
        count+=d[l[i]]

print(count)
