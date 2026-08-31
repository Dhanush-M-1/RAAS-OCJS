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
    freq_a=dd(int)
    freq_b=dd(int)
    #  a = [1,0,2,2]
    #  b = [2,0,1,1]

    for i in a:
        freq_a[i]+=1
    for i in b:
        freq_b[i]+=1
    f=0
    # freq_a = {0:1, 1:1, 2:2 }
    # freq_b = {0:1, 1:2, 2:1 }

    for i in freq_b.keys():
        s_i=set()
        for j in freq_a.keys():
            # frequency of i and j must be same....
            if freq_a[j]==freq_b[i]:
                # we can go i from j add x to j.
                # i = (x+j)%m
                if i>=j:
                    x=i-j
                else:
                    x=(m-j)+i
                s_i.add(x)

        # For every elements in s_i as x,we get every element i in b array     

        # For 1st itteration s = s_i 
        if(f==0):
            s=s_i
            f=1
            continue
        # Otherwise s = intersection(s,s_i) 
        s2=s-s_i
        s=s-s2
    
    # For every element in s as x,we get b array 
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