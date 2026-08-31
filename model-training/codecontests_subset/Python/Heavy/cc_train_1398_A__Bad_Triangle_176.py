ll = lambda: list(map(int, input().split()))
lls=lambda: list(map(str, input().split()))
st= lambda: input()
v = lambda: map(int, input().split())
ii = lambda: int(input())
from math import *
from sys import *
from datetime import datetime
from sys import stdin, stdout
import sys
def lcm(a,b):
    return (a*b)//gcd(a,b)
from collections import *
def modFact(n):
    p=(10**9)+7
    if n >= p:
        return 0
    result = 1
    for i in range(1, n + 1):
        result = (result * i) % p
    return result
def sol(y,i,cost):
    if(i>=len(y)-1):
        return cost
    o=sol(y,i+1,cost)
    e=sol(y,i+2,cost)
    if(abs(y[i]-o)>abs(e-y[i])):
        cost+=abs(y[i]-e)
    else:
        cost+=abs(y[i]-o)
for _ in range(ii()):
    n=ii()
    l=ll()
    a=l[0]+l[1]
    f=1
    for i in range(2,n):
        if(a<=l[i]):
            f=0
            break
    if(f):
        print(-1)
    else:
        print(1,2,i+1)


# x=ii()
# y=ll()
# cost=y[0]
# print(sol(y,0,cost))
# print(cost)







