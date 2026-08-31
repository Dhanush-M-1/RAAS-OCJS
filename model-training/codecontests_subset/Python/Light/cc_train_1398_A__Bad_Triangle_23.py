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
for _ in range(int(input())):
    n=inn()
    a=arr()
    if(a[0]+a[1]<=a[-1]):
        print(1,2,n)
    else:
        print(-1)