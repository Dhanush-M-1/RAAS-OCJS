from math import *
from collections import *
from itertools import *
from bisect import *
from heapq import *
from operator import *
from sys import *
setrecursionlimit(1000000)
# d=defaultdict(lambda:0,{})
def io():
    return map(int,input().split())
def op():
    return list(map(int,input().split()))
def o():
    return int(input())
def r(x):
    return range(len(x))
def kl(con,x=0):
    if x==0:print('Yes') if con else print('No')
    elif x==1:print('yes') if con else print('no')
    elif x==2:print('YES') if con else print('NO')
#MOD = 1000000007
MAX=float('inf')
MIN=-float('inf')
p=input
def cal(l,a,b=MIN):
    if b==MIN:b=a
    l1=l.copy()
    l2=l.copy()
    for i in r(l1):
        if l1[i]==-1:
            l1[i]=a
    m1,m2=MIN,MIN
    for i in range(1,len(l)):
         m1=max(m1,abs(l1[i]-l1[i-1]))
    for i in r(l2):
        if l2[i]==-1:
            l2[i]=b
    for i in range(1,len(l)):
         m2=max(m2,abs(l2[i]-l2[i-1]))
    if m1<m2:print(m1,a)
    else: print(m2,b)
for _ in range(o()):
    n=o()
    l=op()
    m1,m2=MAX,MIN
    if l==[-1]*n:
        print(0,1)
        continue
    for i in r(l):
        if l[i]==-1:
            if i!=0:
                if l[i-1]!=-1:m1=min(m1,l[i-1])
                m2=max(m2,l[i-1])
            if i!=len(l)-1:
                if l[i+1]!=-1:m1 = min(m1, l[i + 1])
                m2 = max(m2, l[i + 1])
    # if (m1+m2)&1:
    #     cal(l,(m1+m2)//2,(m1+m2+1)//2)
    # else:
    cal(l,(m1+m2)//2)