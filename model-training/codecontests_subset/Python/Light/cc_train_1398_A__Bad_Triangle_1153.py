from math import *
from collections import *
from random import *
from decimal import Decimal
from heapq import *
from bisect import *
import sys
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
t=inp()
while(t):
    t-=1
    n=inp()
    a=lis()
    if(a[0]+a[1]<=a[-1]):
        print(1,2,n)
    else:
        print(-1)
            
