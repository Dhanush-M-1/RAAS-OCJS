from functools import reduce
import os
import sys
from math import *
from collections import *
from fractions import *
from bisect import *
from heapq import*
from io import BytesIO, IOBase

input = lambda: sys.stdin.readline().rstrip("\r\n")
def value():return tuple(map(int,input().split()))
def arr():return [int(i) for i in input().split()]
def sarr():return [int(i) for i in input()]
def inn():return int(input())
mo=1000000007
#----------------------------CODE------------------------------#
s=[str(x) for x in input()]
res=[]
for i in s:
    if(i!='+'):
        res+=[int(i)]
res.sort()
for i in range(len(res)-1):
    print(res[i],'+',sep="",end="")
print(res[-1])