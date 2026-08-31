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
ls = lambda : list(input().strip()) # for strings to list of char
from collections import defaultdict as df
import heapq 
#heapq.heapify(li) heappush(li,4) heappop(li)
#import random
#random.shuffle(list)
infinite = float('inf')
#######################################################################

r1,r2=RI()
c1,c2=RI()
d1,d2=RI()

x1=(r1+c1-d2)//2
x2=(r1+c2-d1)//2
x3=(r2+c2-d2)//2
x4=(r2+c1-d1)//2

f=0
if((x1+x2)!=r1 or (x2+x3)!=c2 or (x3+x4)!=r2 or (x4+x1)!=c1 or (x1+x3)!=d1 or (x2+x4)!=d2):
    print(-1)
elif(len(set([x1,x2,x3,x4]))<4 or max([x1,x2,x3,x4])>9 or min([x1,x2,x3,x4])<1):
    print(-1)
else:
    print(x1,end=" ")
    print(x2)
    print(x4,end=" ")
    print(x3)
    
