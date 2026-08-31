import sys
input = sys.stdin.readline
import math
import copy
import collections
from collections import deque

for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    adj = []
    if arr[0]!=-1 and arr[1]==-1:
        adj.append(arr[0])
    if arr[-1]!=-1 and arr[-2]==-1:
        adj.append(arr[-1])
    for i in range(1,n-1):
        if (arr[i-1]==-1 or arr[i+1]==-1) and arr[i]!=-1:
            adj.append(arr[i])
    if adj:
        k = (max(adj)+min(adj))//2
    else:
        k = 0
    for i in range(n):
        if arr[i]==-1:
            arr[i]=k
    m = 0
    for i in range(1,n):
        m = max(m, abs(arr[i]-arr[i-1]))
    print(m,k)