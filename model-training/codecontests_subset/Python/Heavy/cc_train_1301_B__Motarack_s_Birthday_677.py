import math
from decimal import *
import random
import sys

for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    mn, mx = int(1e9), 0
    mid = 0
    for i in range(n):
        if(arr[i]!=-1):
            if(i>0):
                if(arr[i-1]==-1):
                    mn, mx = min(mn, arr[i]), max(mx, arr[i])
                elif(i<n-1):
                    if(arr[i+1]==-1):
                        mn, mx = min(mn, arr[i]), max(mx, arr[i])
            elif(i<n-1):
                if(arr[i+1]==-1):
                    mn, mx = min(mn, arr[i]), max(mx, arr[i])
    if(mn != int(1e9)or mx!= 0):
        mid = (mx+mn)//2
    else:
        mid = 0
    for i in range(n):
        if(arr[i]==-1):
            arr[i] = mid
    m = 0
    for i in range(n-1):
        m = max(m, abs(arr[i]-arr[i+1]))
    print(m , mid)
