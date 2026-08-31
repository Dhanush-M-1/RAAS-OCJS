from math import *
from sys import *
from bisect import *
from collections import *
t=int(stdin.readline())
for _ in range(t):
    n = int(stdin.readline())
    a = list(map(int, stdin.readline().split()))
    d={}
    def fun(low,high,k):
        if low>high:
            return
        mx=0
        j=0
        for i in range(low,high+1):
            if mx<a[i]:
                j=i
                mx=a[i]
        d[mx]=k
        fun(low,j-1,k+1)
        fun(j+1,high,k+1)
    fun(0,n-1,0)
    ans=[]
    for i in range(n):
        ans.append(d[a[i]])
    print(*ans)