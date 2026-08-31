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
        l1.sort()
        l2.sort()
        f=0
        for i in range(n):
            if bs(l2,l1[i],0,m-1)!=(-1):
                print("YES")
                print(1,l1[i])
                f=1
                break
            else:
                f=0
                continue
        if f==0:
            print("NO")
        
            
            
        
            
        
if __name__=="__main__":
    solve()

