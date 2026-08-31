import sys,os,io
from sys import stdin
from math import log, gcd, ceil
from collections import defaultdict, deque, Counter
from heapq import heappush, heappop, heapify
from bisect import bisect_left , bisect_right
import math 
def ii():
    return int(input())
def li():
    return list(map(int,input().split()))
if(os.path.exists('input.txt')):
    sys.stdin = open("input.txt","r") ; sys.stdout = open("output.txt","w") 
else:
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

no = "NO"
yes = "YES"
def solve():
    n,q = li()
    a = li()
    d = defaultdict(lambda:0)
    for i in a:
        d[i]+=1
    # print(d)
    k = list(d.keys())
    k.sort()
    k.reverse()
    # print(k)
    for i in range(q):
        b = ii()
        cnt=0
        # print(b)
        f=0
        for j in k:
            # print("j",j)
            # print(b)
            cnt+=min(d[j],b//j)
            b = b - j*min(d[j],b//j)
            # print(b)
        
        if b!=0:
            cnt=-1
        print(cnt)




t = 1
# t = int(input())
for _ in range(t):
    solve()
    
