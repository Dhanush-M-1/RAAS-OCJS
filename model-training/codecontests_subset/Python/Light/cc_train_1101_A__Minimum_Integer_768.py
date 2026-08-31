import sys
from collections import defaultdict as dd
input=sys.stdin.readline
n=int(input())
##d=dd(int)
for i in range(n):
    l,r,d=map(int,input().split())
    if(d*1<l):
        print(d*1)
    else:
        print(((r//d)+1)*d)
    
    
##l=list(map(int,input().split()))
