'''
    Auther: ghoshashis545 Ashis Ghosh
    College: jalpaiguri Govt Enggineering College

'''
from os import path
import sys
from functools import cmp_to_key as ctk
from collections import deque,defaultdict as dd 
from bisect import bisect,bisect_left,bisect_right,insort,insort_left,insort_right
from itertools import permutations
from datetime import datetime
from math import ceil,sqrt,log,gcd
def ii():return int(input())
def si():return input()
def mi():return map(int,input().split())
def li():return list(mi())
abc='abcdefghijklmnopqrstuvwxyz'
mod=1000000007
#mod=998244353
inf = float("inf")
vow=['a','e','i','o','u']
dx,dy=[-1,1,0,0],[0,0,1,-1]

def bo(i):
    return ord(i)-ord('a')



def solve():
    
    

    # for _ in range(ii()):
        

    n,k=mi()
    x=[]
    y=[]
    z=[]
    for i in range(n):
        a=li()
        if a[1] and a[2]:
            x.append(a[0])
        elif(a[1]==1):
            y.append(a[0])
        elif(a[2]==1):
            z.append(a[0])
    n1=min(len(y),len(z))
    x.sort()
    y.sort()
    z.sort()
    for i in range(1,len(x)):
        x[i]+=x[i-1]
    for i in range(1,len(y)):
        y[i]+=y[i-1]
    for i in range(1,len(z)):
        z[i]+=z[i-1]

    if len(x)+n1<k:
        print('-1')
        exit(0)
    ans=inf
    if(len(x)>=k):
        ans=x[k-1]
        n2=0
    else:
        n2=k-len(x)-1
    c=0
    for i in range(n2,n1):
        if i>=k:
            break
        x2=k-i-1
        if(x2<1):
            ans=min(ans,z[i]+y[i])
        else:
            ans=min(ans,x[x2-1]+z[i]+y[i])
        c+=1

    print(ans)
















        
if __name__ =="__main__":

    if path.exists('input.txt'):
        sys.stdin=open('input.txt', 'r')
        sys.stdout=open('output.txt','w')
    else:
        input=sys.stdin.readline
    solve()
