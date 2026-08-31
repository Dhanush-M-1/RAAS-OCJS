#This code is contributed by Siddharth
import time
import heapq
import sys
from collections import *
from heapq import *
import math
import bisect
from itertools import *
mod=10**9+7




n=int(input())
l=[]
dic=defaultdict(int)
for i in range(n):
    x,h=map(int,input().split())
    l.append([x,h])
l.sort(key=lambda x:x[0])
last=-1*(10**18)
cnt=0
for i in range(n):
    if i==0:
        last=l[0][0]
        cnt+=1
    elif i==n-1:
        cnt+=1
    else:
        h=l[i][1]
        x=l[i][0]
        if (x-h)>last:
            last=x
            cnt+=1
        elif (x+h)<l[i+1][0]:
            last=x+h
            cnt+=1
    last=max(last,l[i][0])
print(cnt)