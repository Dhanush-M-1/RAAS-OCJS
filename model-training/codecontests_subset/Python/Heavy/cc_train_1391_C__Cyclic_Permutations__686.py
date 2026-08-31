ll = lambda: list(map(int, input().split()))
lls=lambda: list(map(str, input().split()))
st= lambda: input()
v = lambda: map(int, input().split())
ii = lambda: int(input())
#from math import *
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
mod=10**9+7
n=ii()
s=modFact(n)
print((s- pow(2,n-1,mod))%mod)

