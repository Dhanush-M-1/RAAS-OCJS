import math as mt 
import sys,string,bisect
input=sys.stdin.readline
from collections import deque,defaultdict
L=lambda : list(map(int,input().split()))
Ls=lambda : list(input().split())
M=lambda : map(int,input().split())
I=lambda :int(input())
a,b=input().split()
print(a,b)
n=I()
for i in range(n):
    k=input().split()
    if(a==k[0]):
        a=k[1]
    else:
        b=k[1]
    print(a,b)
