from  bisect import bisect_right as br
import sys
from collections import *
from math import *
import re
def sieve(n):
    prime=[True for i in range(n+1)]
    p=2
    while p*p<=n:
        if prime[p]==True:
            for i in range(p*p,n+1,p):
                prime[i]=False
        p+=1
    c=0
    for i in range(2,n):
        if prime[i]:
            #print(i)
            c+=1
    return c
def totient(n):
    res,p=n,2
    while p*p<=n:
        if n%p==0:
            while n%p==0:
                n=n//p
            res-=int(res/p)
        p+=1
    if n>1:res-=int(res/n)
    return res
    

def iseven(n):return[False,True][0 if n%2 else 1]
def inp_matrix(n):return list([input().split()] for i in range(n))
def inp_arr():return list(map(int,input().split()))
def inp_integers():return map(int,input().split())
def inp_strings():return input().split()
def lcm(a,b):return (a*b)/gcd(a,b)
max_int = sys.maxsize
mod = 10**9+7
flag1=False
flag2=False


n,k=inp_integers()
arr=inp_arr()
ans=0
print(k//max([i for i in arr if k%i==0]))