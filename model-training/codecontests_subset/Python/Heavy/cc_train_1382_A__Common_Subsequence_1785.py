import math
import os
import random
import re
import sys
import copy
from collections import Counter
def bs(arr,x,l,r):
    if l<=r:
        mid=(r+l)//2
        if arr[mid]==x:
            return mid
        elif arr[mid]<x:
            return bs(arr,x,mid+1,r)
        else:
            return bs(arr,x,l,mid-1)
    else:
        return -1
def solve():
    for _ in range(int(input())):
        n,m=map(int,input().strip().split())
        l1=list(map(int,input().strip().split()))
        l2=list(map(int,input().strip().split()))
        s1=set(l1)
        s2=set(l2)
        s=s1.intersection(s2)
        s=list(s)
        if len(s)>0:
            print("YES")
            print(1,s[0])
        else:
            print("NO")
            
if __name__=="__main__":
    solve()

