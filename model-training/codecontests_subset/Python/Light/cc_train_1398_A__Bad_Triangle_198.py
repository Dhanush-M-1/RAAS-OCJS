from collections import defaultdict as dd
import sys
input=sys.stdin.readline
t=int(input())
while t:
    n=int(input())
    #n,m=map(int,input().split())
    l=list(map(int,input().split()))
    lol=0
    if(l[0]+l[1]<=l[-1]):
        print(1,2,n)
        lol=1
    if(lol==0):
        print(-1)
    t-=1
