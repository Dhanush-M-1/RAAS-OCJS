"""
    This template is made by Satwik_Tiwari.
    python programmers can use this template :)) .
"""

#===============================================================================================
#importing some useful libraries.

import sys
import bisect
import heapq
from math import *
from collections import Counter as counter  # Counter(list)  return a dict with {key: count}
from itertools import combinations as comb # if a = [1,2,3] then print(list(comb(a,2))) -----> [(1, 2), (1, 3), (2, 3)]
from itertools import permutations as permutate
from bisect import bisect_left as bl #
from bisect import bisect_right as br
from bisect import bisect

#===============================================================================================
#some shortcuts

mod = pow(10, 9) + 7
def inp(): return sys.stdin.readline().strip() #for fast input
def out(var): sys.stdout.write(str(var))  #for fast output, always take string
def lis(): return list(map(int, inp().split()))
def stringlis(): return list(map(str, inp().split()))
def sep(): return map(int, inp().split())
def strsep(): return map(str, inp().split())
def graph(vertex): return [[] for i in range(0,vertex+1)]
def zerolist(n): return [0]*n
def nl(): out("\n")  #as stdout.write always print sring.
def testcase(t):
    for p in range(t):
        solve()
def printlist(a) :
    for p in range(0,len(a)):
        out(str(a[p]) + ' ')
def lcm(a,b): return (a*b)//gcd(a,b)


#===============================================================================================
# code here ;))

def solve():
    n = int(inp())
    a = lis()

    arr = []
    for i in range(0,n):
        if(a[i]==-1):
            continue
        if(i==0):
            if(a[i+1] == -1):
                arr.append(a[i])
            continue
        if(i==n-1):
            if(a[i-1] == -1):
                arr.append(a[i])
            continue
        if(a[i-1]==-1 or a[i+1]==-1):
            arr.append(a[i])
    # print(arr)
    if(len(arr) == 0):
        print(0,0)
    else:
        k = (max(arr)+min(arr))//2
        st =max(0,k-10)
        val = -1
        ans = mod

        for i in range(st,k+10):
            lol = []
            for j in range(0,n):
                if(a[j]==-1):
                    lol.append(i)
                else:
                    lol.append(a[j])
            temp = -1
            for j in range(1,n):
                temp = max(temp,abs(lol[j]-lol[j-1]))
            if(temp < ans):
                ans= temp
                val = i
            # print(ans,val,lol)
        print(ans,val)

testcase(int(inp()))
# testcase(1)













