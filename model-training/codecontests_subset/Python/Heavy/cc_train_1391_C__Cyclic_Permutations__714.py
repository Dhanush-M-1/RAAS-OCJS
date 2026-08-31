from functools import reduce
import os
import sys
from collections import *
#from fractions import *
from math import *
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
n=inn()
fact=1
for i in range(1,n+1):
    fact=(fact*i)%mo
res=(fact-2**(n-1))%mo
print(res)



