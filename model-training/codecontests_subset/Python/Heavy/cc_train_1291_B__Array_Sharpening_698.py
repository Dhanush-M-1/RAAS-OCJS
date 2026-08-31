from functools import reduce
import os
import sys
from math import *
from collections import *
from fractions import *
from bisect import *
from heapq import *
from io import BytesIO, IOBase
input = lambda: sys.stdin.readline().rstrip("\r\n")
def value(): return tuple(map(int, input().split())) # multiple values
def arr(): return [int(i) for i in input().split()] # array input
def sarr(): return [int(i) for i in input()] #array from string
def starr(): return [str(x) for x in input().split()] #string array
def inn(): return int(input()) # integer input
def svalue(): return tuple(map(str, input().split())) #multiple string values
def parr(): return [(value()) for i in range(n)] # array of pairs
mo = 1000000007
# ----------------------------CODE------------------------------#
for _ in range(inn()):
    n=inn()
    a=arr()
    if(min(a)>=n):
        print("YES")
        continue
    ans='No'
    flag=0
    for i in range(n):
        if(a[i]<i):
            flag=1
    if(flag==0):
        print("Yes")
        continue
    flag=0
    for i in range(n):
        if(a[i]<n-i-1):
            flag=1
    if(flag==0):
        print("Yes")
        continue
    flag=0
    for i in range(n):
        if(a[i]<i and a[i]<n-i-1):
            flag=1
    if(n%2==0):
        res=n//2
        if(a[res]==a[res-1]==res-1):
            flag=1
    if(flag==0):
        print("Yes")
        continue
    print(ans)




