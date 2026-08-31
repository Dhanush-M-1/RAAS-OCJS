# cook your dish here
#code
import math
import collections
from sys import stdin,stdout,setrecursionlimit
from bisect import bisect_left as bsl
from bisect import bisect_right as bsr
import heapq as hq
setrecursionlimit(2**20)

t = 1
t = int(stdin.readline())

for _ in range(t):
    n = int(stdin.readline())
    
    d = {2:0,3:0}
    tmp = n
    while(tmp%2==0):
        tmp = tmp//2
        d[2] += 1
    while(tmp%3==0):
        tmp = tmp//3
        d[3] += 1
        
    if( (2**d[2])*(3**d[3]) != n ):
        print(-1)
        continue
    else:
        if(d[2]>d[3]):
            print(-1)
            continue
        else:
            print( d[3] + d[3]-d[2] )