from collections import Counter
from collections import defaultdict
from collections import deque
import math
import heapq
import sys
import io, os

input = sys.stdin.readline
# input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
from bisect import *

rs = lambda: input().strip()
ri = lambda: int(input())
rl = lambda: list(map(int, input().strip().split()))
rls = lambda: list(map(str, input().split()))


t=int(input())
for _ in range(0,t):
    n=int(input())
    x=2
    c1=0
    c2=0
    f=1
    while(n!=1):
        if(n%2==0):
            n=n//2
            c1=c1+1
        elif(n%3==0):
            n=n//3
            c2=c2+1
        else:
            f=0
            #print(-1)
            break
    if(c1>c2 or f==0):
        print(-1)
    else:
        print(c2+(c2-c1))
