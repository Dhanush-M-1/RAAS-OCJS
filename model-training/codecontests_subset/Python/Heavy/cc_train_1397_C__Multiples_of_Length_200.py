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

file=1





    
def solve():

    # for _ in range(ii()):
        
        
    n = ii()
    a = li()
    if(n==1):
        print(1,1)
        print(0)
        print(1,1)
        print(0)
        print(1,1)
        print(-a[0])
        return

    print(1,1)
    print(a[0]*n-a[0])
    print(2,n)
    for i in range(1,n):
        print(a[i]*(n-1),end=" ")
    print()
    print(1,n)
    for i in range(n):
        print(-a[i]*n,end=" ")














        
if __name__ =="__main__":

    if(file):

        if path.exists('input.txt'):
            sys.stdin=open('input.txt', 'r')
            sys.stdout=open('output.txt','w')
        else:
            input=sys.stdin.readline
    solve()