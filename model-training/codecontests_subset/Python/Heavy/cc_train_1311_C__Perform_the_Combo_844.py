from collections import defaultdict as dc
import sys
import math
input=sys.stdin.readline
x=list("abcdefghijklmnopqrstuvwxyz")
for _ in range(int(input())):
    n,m=map(int,input().split())
    s=input()[:-1]
    l=list(map(int,input().split()))
    p=[0]*n
    for i in l:
        p[i-1]+=1
    #print('p0',p)a
    for i in range(n-2,-1,-1):
        p[i]=p[i]+p[i+1]
    #print('p',p)
    p=[p[i]+1 for i in range(n)]
    #print('p1',p)
    g=dc(int)
    for i in range(n):
        g[s[i]]+=p[i]
    q=[]
    for i in x:
        q.append(g[i])
    print(*q)
    