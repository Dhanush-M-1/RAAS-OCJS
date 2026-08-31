import sys
from sys import stdin
import math
#Find Set LSB = (x&(-x)), isPowerOfTwo = (x & (x-1))
def iinput():
    return int(input())
def minput():
    return map(int,input().split())
def linput():
    return list(map(int,input().split()))

def fiinput():
    return int(stdin.readline())
def fminput():
    return map(int,stdin.readline().strip().split())
def flinput():
    return list(map(int,stdin.readline().strip().split()))


for _ in range(iinput()):
    n=iinput()
    list1=linput()
    x=list1[0]
    y=list1[1]
    z=list1[-1]
    if(x+y<=z):
        print(1,2,n)
    else:
        print(-1)