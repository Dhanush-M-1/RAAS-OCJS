from bisect import bisect_left as bl, bisect_right as br, insort
import sys
import heapq
#from math import *
from collections import defaultdict as dd, deque
def data(): return sys.stdin.readline().strip()
def mdata(): return map(int, data().split())
#sys.setrecursionlimit(100000)


for i in range(int(data())):
    n=int(data())
    a,b=0,0
    flag=True
    for i in range(n):
        p,c=mdata()
        if p<a or c<b or c>p or c>p-a+b:
            flag=False
        a=p
        b=c
    if flag==False:
        print("NO")
    else:
        print("YES")