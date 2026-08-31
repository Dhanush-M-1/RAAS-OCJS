
from math import *
from sys import *
from collections import defaultdict
M=10**9+7
def pow(a,b):
    res=1
    while b>0:
        if b&1:
            res*=a
        a*=a
        b>>=1
    return res
def powmod(a,b,m):
    res=1
    while b>0:
        if b&1:
            res=((res*a)%m)
        a*=a
        b>>=1
    return res
def inv(a,m):
    return powmod(a,m-2,m)

def factor(n):
    potentional_p = 3
    itog_list = {}
    if n % 2 == 0:
        itog_list[2] = 0
    while n % 2 == 0:
        n = n // 2
        itog_list[2] += 1
    while n - 1:
        if potentional_p > (n**0.5):
            if n in itog_list:
                itog_list[n] += 1
            else:
                itog_list[n] = 1
            return itog_list
        while n % potentional_p == 0:
            n = n // potentional_p
            if potentional_p in itog_list:
                itog_list[potentional_p] += 1
            else:
                itog_list[potentional_p] = 1
        potentional_p += 2
    return itog_list

t=int(stdin.readline())
for _ in range(t):
    a,b,n=list(map(int,stdin.readline().split()))
    n%=3
    if n==0:
        print(a)
    if n==1:
        print(b)
    if n==2:
        print(a^b)



