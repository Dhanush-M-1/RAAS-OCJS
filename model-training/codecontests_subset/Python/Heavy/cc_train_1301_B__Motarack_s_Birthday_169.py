'''
    Auther: ghoshashis545 Ashis Ghosh
    College: jalpaiguri Govt Enggineering College

'''
from os import path
import sys
from heapq import heappush,heappop
from functools import cmp_to_key as ctk
from collections import deque,defaultdict as dd 
from bisect import bisect,bisect_left,bisect_right,insort,insort_left,insort_right
from itertools import permutations
from datetime import datetime
from math import ceil,sqrt,log,gcd
def ii():return int(input())
def si():return input().rstrip()
def mi():return map(int,input().split())
def li():return list(mi())
abc='abcdefghijklmnopqrstuvwxyz'
mod=1000000007
# mod=998244353
inf = float("inf")
vow=['a','e','i','o','u']
dx,dy=[-1,1,0,0],[0,0,1,-1]

def bo(i):
    return ord(i)-ord('a')

file = 1



    
def solve():


    
    for _ in range(ii()):

        
        n = ii()
        a = li()

        def can(x):
            mx = 0
            b= []
            for i in range(n):
                if a[i]==-1:
                    b.append(x)
                else:
                    b.append(a[i])
            for i in range(1,n):
                mx = max(mx,abs(b[i]-b[i-1]))
            return mx

        l = 0
        r =int(1e9)
        while(l<=r):
            m = l+(r-l)//2
            x = can(m)
            if m>0:
                x1 = can(m-1)
            if m < int(1e9):
                x2 = can(m+1) 

            if x<=x1 and x<=x2:
                ans1 = m
                ans2 = x
                break
            if x1<x2:
                ans1 = m-1
                ans2 = x1
                r = m-1
            else:
                l = m+1
        print(ans2,ans1)








        
if __name__ =="__main__":

    if(file):

        if path.exists('input.txt'):
            sys.stdin=open('input.txt', 'r')
            sys.stdout=open('output.txt','w')
        else:
            input=sys.stdin.readline
    solve()
