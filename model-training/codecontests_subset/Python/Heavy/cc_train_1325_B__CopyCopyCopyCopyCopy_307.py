import os, sys, bisect, copy
from collections import defaultdict, Counter, deque
from functools import lru_cache   #use @lru_cache(None)
if os.path.exists('in.txt'): sys.stdin=open('in.txt','r')
if os.path.exists('out.txt'): sys.stdout=open('out.txt', 'w')
#
def input(): return sys.stdin.readline()
def mapi(arg=0): return map(int if arg==0 else str,input().split())
#------------------------------------------------------------------

def CeilIndex(A, l, r, key):
    while (r - l > 1):
        m = l + (r - l)//2
        if (A[m] >= key):
            r = m
        else:
            l = m
    return r

def lis(A, size):
    tailTable = [0 for i in range(size + 1)]
    ln = 0
    tailTable[0] = A[0]
    ln = 1
    for i in range(1, size):
        if (A[i] < tailTable[0]):
            tailTable[0] = A[i]
        elif (A[i] > tailTable[ln-1]):
            tailTable[ln] = A[i]
            ln+= 1
        else:
            tailTable[CeilIndex(tailTable, -1, ln-1, A[i])] = A[i]
    return ln

for _ in range(int(input())):
    n = int(input())
    a = list(mapi())
    #a = a*3
    #print(lis(a,3*n))
    mp = {}
    res = 0
    for i in a:
        if i not in mp:
            res+=1
            mp[i]=1
    print(res)