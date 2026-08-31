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
def nextline(): out("\n")  #as stdout.write always print sring.
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
    a = n
    b = n-1
    ans = a*b
    if(n==1):
        print(1)
    elif(n == 2):
        print(2)
    elif(n==3):
        print(6)
    elif(n>20):
        ans = 0
        for i in range(n-20,n+1):
            for j in range(n-20,n+1):
                for k in range(n-20,n+1):
                    ans = max(ans,lcm(lcm(i,j),k))
        print(ans)
    else:
        ans = 0
        for i in range(1,n+1):
            for j in range(1,n+1):
                for k in range(1,n+1):
                    ans = max(ans,lcm(lcm(i,j),k))
        print(ans)


testcase(1)

