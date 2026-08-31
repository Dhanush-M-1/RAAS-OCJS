import math,sys
from collections import Counter, defaultdict, deque
from sys import stdin, stdout
input = stdin.readline
lili=lambda:list(map(int,sys.stdin.readlines()))
li = lambda:list(map(int,input().split()))
#for deque append(),pop(),appendleft(),popleft(),count()
I=lambda:int(input())
S=lambda:input().strip()

n,m=li()
a=li()
b=li()
a.sort()
b.sort()
ans=m+1
for i in range(0,n):
    d=(b[i]-a[0]+m)%m
    c=[0]*n
    for j in range(0,n):
        c[j]=(a[j]+d)%m
    c.sort()
    if(b==c):
        ans=min(ans,d)
print(ans)