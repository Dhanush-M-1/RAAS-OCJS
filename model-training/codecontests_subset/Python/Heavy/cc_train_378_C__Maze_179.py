# cook your dish here
import sys
from functools import lru_cache, cmp_to_key
from heapq import merge, heapify, heappop, heappush
from math import *
from collections import defaultdict as dd, deque, Counter as C
from itertools import combinations as comb, permutations as perm
from bisect import bisect_left as bl, bisect_right as br, bisect
from time import perf_counter
from fractions import Fraction
import copy
import time
starttime = time.time()
mod = int(pow(10, 9) + 7)
mod2 = 998244353
# from sys import stdin
# input = stdin.readline
def data(): return sys.stdin.readline().strip()
def out(*var, end="\n"): sys.stdout.write(' '.join(map(str, var))+end)
def L(): return list(sp())
def sl(): return list(ssp())
def sp(): return map(int, data().split())
def ssp(): return map(str, data().split())
def l1d(n, val=0): return [val for i in range(n)]
def l2d(n, m, val=0): return [l1d(n, val) for j in range(m)]
try:
    # sys.setrecursionlimit(int(pow(10,7)))
    sys.stdin = open("input.txt", "r")
    # sys.stdout = open("../output.txt", "w")
except:
    pass
def pmat(A):
    for ele in A:
        print(*ele,end="\n")
def seive():
    prime=[1 for i in range(10**6+1)]
    prime[0]=0
    prime[1]=0
    for i in range(10**6+1):
        if(prime[i]):
            for j in range(2*i,10**6+1,i):
                prime[j]=0
    return prime

n,m,k=L()
A=[list(sl()[0]) for i in range(n)]

def bfs(x,y):
    q=deque()
    q.append([x,y])
    vis=[[0 for i in range(m)] for j in range(n)]
    vis[x][y]=1
    row=[0,-1,1,0]
    col=[-1,0,0,1]
    d=1
    while(q):
        i,j=q.popleft()
        for val in range(4):
            a=i+row[val]
            b=j+col[val]
            if a>=0 and b>=0 and a<n and b<m and vis[a][b]==0 and A[a][b]==".":
                vis[a][b]=1
                d+=1
                if d>cnt-k:
                    A[a][b]="X"
                q.append([a,b])



cnt=0
for i in range(n):
    for j in range(m):
        if A[i][j]==".":
            cnt+=1
            x,y=i,j
# print(cnt)
bfs(x,y)
for ele in A:
    print("".join(ele))










endtime = time.time()
# print(f"Runtime of the program is {endtime - starttime}")

