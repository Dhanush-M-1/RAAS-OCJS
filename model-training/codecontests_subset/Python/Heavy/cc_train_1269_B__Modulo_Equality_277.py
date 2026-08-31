'''
    Auther: ghoshashis545 Ashis Ghosh
    College: jalpaiguri Govt Enggineering College

'''
from os import path
import sys
from heapq import heappush,heappop,heapify
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

def b(i):
    # ord(i) -> Ascii value of i
    return ord(i)-ord('a')

file=1


def solve():


    n,m=mi()
    a=li()
    b=li()
    s=set()
    m1=dd(int)
    m2=dd(int)
    for i in a:
        m1[i]+=1
    for i in b:
        m2[i]+=1
    f=0
    for i in m2.keys():
        s1=set()
        for j in m1.keys():
            if m1[j]==m2[i]:
                if i>=j:
                    x=i-j
                else:
                    x=(m-j)+i
                s1.add(x)
        # print(s,s1)
        if(f==0):
            s=s1
            f=1
            continue
        s2=s-s1
        s=s-s2
    # print(s)
    s=list(s)
    print(min(s))


        

        



    










        
if __name__ =="__main__":

    if(file):

        if path.exists('input.txt'):
            sys.stdin=open('input.txt', 'r')
            sys.stdout=open('output.txt','w')
        else:
            input=sys.stdin.readline
    solve()