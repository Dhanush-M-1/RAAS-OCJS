import math
import time
from collections import defaultdict,deque,Counter
from sys import stdin,stdout
from bisect import bisect_left,bisect_right
from queue import PriorityQueue 
import sys
t=1
t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,stdin.readline().split()))
    if(a[-1]>=a[0]+a[1]):
        print(1,2,n)
    else:
        print(-1)