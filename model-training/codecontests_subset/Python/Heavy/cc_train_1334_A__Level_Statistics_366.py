import sys
input=sys.stdin.readline
from math import *
def bo(i):
    return ord(i)-ord('a')+1
t=int(input())
while t>0:
    t-=1
    n=int(input())
    flag=0
    prevp=0
    prevc=0
    for i in range(n):
        p,c=map(int,input().split())
        if flag==1:
            continue
        elif p<prevp or c<prevc:
            flag=1
            continue
        elif p-prevp<c-prevc:
            flag=1
            continue
        elif p<c:
            flag=1
            continue
        prevp=p
        prevc=c
    print("YES" if flag==0 else "NO")    
