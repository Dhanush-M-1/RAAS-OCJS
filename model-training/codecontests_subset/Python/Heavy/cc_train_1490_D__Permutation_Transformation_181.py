import sys
from collections import *
import math
import bisect
sys.setrecursionlimit(10**9)
def input():
    return sys.stdin.readline()


def rec(l,arr):
    if len(arr)==0:
        return
    ind=arr.index(max(arr))
    lev[dic[max(arr)]]=l
    rec(l+1,arr[:ind])
    rec(l+1,arr[ind+1:])
    return

for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    dic={}
    for i in range(n):
        dic[a[i]]=i
    lev=[-1 for _ in range(n)]
    rec(0,a)
    print(*lev)