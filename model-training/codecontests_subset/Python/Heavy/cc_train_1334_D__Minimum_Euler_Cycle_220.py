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
    n,l,r = mapi()
    low = 1
    high = n-1
    pst = 0
    def check(pst,n,l):
        val = 2*n*pst-(pst*pst)-pst
        if val < l:
            return True
        return False
    while low <= high:
        mid = (low+high)//2
        if check(mid,n,l):
            pst = mid
            low = mid+1
        else:
            high = mid-1
    val = 2*n*pst-(pst*pst)-pst
    rem = l-val
    #print(pst)
    temp = True
    prev = True
    for i in range(rem-1):
        if prev:
            if temp:
                pst += 1
                nxt = pst
        else:
            nxt += 1
            temp = False
        if nxt == n:
            temp = True
        prev = not prev
        #print(pst,nxt)
    #print(temp,prev,nxt)
    res = []
    for i in range(r-l+1):
        if prev:
            if temp:
                pst += 1
                nxt = pst
            if pst == n:
                pst = 1
            res.append(pst)
        else:
            temp = False
            nxt += 1
            res.append(nxt)
        if nxt == n:
            temp = True
        prev = not prev
    print(*res)


