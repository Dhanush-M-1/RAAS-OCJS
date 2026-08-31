import sys
import bisect
t=int(input())
for _ in range(t):
    #n,m=map(int,input().split())
    #l=list(map(int,input().split()))
    #l2=list(map(int,input().split()))
    n=int(input())
    l=list(map(int,input().split()))
    i1,j1,k1=0,0,0
    if l[0]+l[1]<=l[n-1]:
        i1,j1,k1=1,2,n
    if i1*j1*k1==0:
        print(-1)
    else:
        print(i1,j1,k1)