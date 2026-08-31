import os, sys, bisect, copy
from collections import defaultdict, Counter, deque
from functools import lru_cache   #use @lru_cache(None)
if os.path.exists('in.txt'): sys.stdin=open('in.txt','r')
if os.path.exists('out.txt'): sys.stdout=open('out.txt', 'w')
#
def input(): return sys.stdin.readline()
def mapi(arg=0): return map(int if arg==0 else str,input().split())
#------------------------------------------------------------------

for _ in range(int(input())):
    n = int(input())
    a = []
    l1 = 0
    l2 = 0
    f1 = 1
    pf = []
    for i in range(n):
        x,y = mapi()
        #print(x,l1,y,l2)
        if not (x>=l1 and y>=l2 and x-l1>=y-l2):
            f1 = 0
        l1 = max(l1,x)
        l2 = max(l2,y)
    if f1:
        print("YES")
    else:
        print("NO")


