#from math import *
from collections import *
from random import *
from decimal import Decimal
from heapq import *
from bisect import *
import sys
from itertools import *
input=sys.stdin.readline
sys.setrecursionlimit(10**5)
def lis():
    return list(map(int,input().split()))
def ma():
    return map(int,input().split())
def inp():
    return int(input())
def st1():
    return input().rstrip('\n')
t=1
while(t):
    t-=1
    n=inp()
    x=1
    p=1000000007
    for i in range(1,n+1):
        x=x*(i)
        x=x%p
    y=pow(2,n-1,p)
    print((x-y)%p)
        
    
    
