import os,sys
from io import BytesIO, IOBase

import math

def ii(): return int(input())
def si(): return input()
def mi(): return map(int,input().split())
def li(): return list(mi()) 

def Diff(li1, li2): 
    return (list(set(li1) - set(li2))) 

n=ii()
l1=li()
l2=li()
l3=li()
l1.sort()
l2.sort()
l3.sort()
f=1
for i in range(n-1):
    if l1[i]!=l2[i]:
        print(l1[i]) 
        f=0
        break
if f:
    print(l1[-1])
f=1
for i in range(n-2):
    if l2[i]!=l3[i]:
        print(l2[i])
        f=0
        break
if f:
    print(l2[-1])