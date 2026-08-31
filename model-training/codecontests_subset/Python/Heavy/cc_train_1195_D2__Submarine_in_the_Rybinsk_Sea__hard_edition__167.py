'''
    Auther: ghoshashis545 Ashis Ghosh
    College: jalpaiguri Govt Enggineering College

'''
from os import path
from io import BytesIO, IOBase
import sys
from heapq import heappush,heappop
from functools import cmp_to_key as ctk
from collections import deque,Counter,defaultdict as dd 
from bisect import bisect,bisect_left,bisect_right,insort,insort_left,insort_right
from itertools import permutations
from datetime import datetime
from math import ceil,sqrt,log,gcd
def ii():return int(input())
def si():return input().rstrip()
def mi():return map(int,input().split())
def li():return list(mi())
abc='abcdefghijklmnopqrstuvwxyz'
# mod=1000000007
mod=998244353
inf = float("inf")
vow=['a','e','i','o','u']
dx,dy=[-1,1,0,0],[0,0,1,-1]

def bo(i):
    return ord(i)-ord('0')

file = 1
def ceil(a,b):
    return (a+b-1)//b




def solve():


    # for _ in range(ii()):
    N = 10001
    invfact = [0]*N
    fact = [1]*N
    for i in range(1,N):
        fact[i] = (fact[i-1]*i)%mod
    invfact[-1] = pow(fact[-1],mod-2,mod)
    for i in range(N-2,-1,-1):
        invfact[i] = ((i+1)*invfact[i+1])%mod

    def nCr(x,y):
        if y > x:
            return 0
        ans = (invfact[x-y]*invfact[y])%mod
        ans *= fact[x]
        ans %= mod
        return ans

    n = ii()
    a = list(map(str,input().split()))

    count = [0]*21
    elem_size = [0]*11
    for i in a:
        elem_size[len(i)]+=1

    for i in range(n):
        n1 = len(a[i])
        cur = list(a[i])
        for j in range(1,n1):
            idx = 0
            x = n1-j
            k = 2*j+x-1
            while x:
                count[k] += (2*elem_size[j]*int(cur[idx]))%mod
                count[k] %= mod
                x-=1
                k-=1
                idx+=1
            f = 0
            for k1 in range(k,-1,-1):
                count[k1] += (elem_size[j]*int(cur[idx]))%mod
                count[k1] %= mod
                if f:
                    idx+=1
                f^=1
            
        for j in range(n1,11):
            idx = 0
            f = 0
            for k in range(2*n1-1,-1,-1):
                count[k] += (elem_size[j]*int(cur[idx]))%mod
                count[k] %= mod
                if f:
                    idx +=1
                f ^=1



    ans = 0
    pw = 1
    for i in range(21):
        ans += (count[i]*pw)%mod
        ans %= mod
        pw *= 10
        pw %= mod

    print(ans)










            





    
        








        
if __name__ =="__main__":

    if(file):

        if path.exists('tmp/input.txt'):
            sys.stdin=open('tmp/input.txt', 'r')
            sys.stdout=open('tmp/output.txt','w')
        else:
            input=sys.stdin.readline
    solve()
