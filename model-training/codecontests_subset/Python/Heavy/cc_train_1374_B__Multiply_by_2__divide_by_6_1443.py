import math
import sys
import collections
from collections import defaultdict
from sys import stdin, stdout
MOD = 10**9 + 7


def take_root(num):
    return math.ceil(math.sqrt(num))

def sieve():
    limit = 86028121
    isprime=[1]*(86028122)
    isprime[0]=0
    isprime[1]=0
    for i in range(2,take_root(limit+1)):
        if isprime[i]==1:
            for j in range(i*i,limit+1,i):
                isprime[j]=0
    
    primes=[]
    for i in range(limit+1):
        if isprime[i]==True:
            primes.append(i)
    
    return primes

def minput():
    return map(int,input().split())

def iinput():
    return int(input())

def strinput():
    return input()

def linput():
    return list(map(int,input().split()))

for _ in range(iinput()):
    n=iinput()
    if n==1:
        print(0)
    else:
        temp1 = 0
        while n>0 and n%6==0:
            n=n//6
            temp1+=1
        temp2=0
        while n>0 and n%3==0:
            n=n//3
            temp2+=1
        if n==1:
            print(temp1+(2*temp2))
        else:
            print(-1)