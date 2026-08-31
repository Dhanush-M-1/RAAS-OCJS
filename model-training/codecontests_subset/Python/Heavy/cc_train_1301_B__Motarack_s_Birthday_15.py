import math,sys
from collections import Counter, defaultdict, deque
from sys import stdin, stdout
input = stdin.readline
lili=lambda:list(map(int,sys.stdin.readlines()))
li = lambda:list(map(int,input().split()))
#for deque append(),pop(),appendleft(),popleft(),count()
I=lambda:int(input())
S=lambda:input().strip()
mod = 1000000007

for i in range(I()):
    n=I()
    a=li()
    d=0
    b=[]
    for i in range(1,n-1):
        if(a[i]==-1):
            if(a[i-1]!=-1):
                b.append(a[i-1])
            if(a[i+1]!=-1):
                b.append(a[i+1])
    if(a[0]==-1 and a[1]!=-1):
        b.append(a[1])
    if(a[-1]==-1 and a[-2]!=-1):
        b.append(a[-2])
        
    b.sort()
    #print(*b)
    if(len(b)==0):
        print(0,0)
        continue
    k=(b[0]+b[-1])//2
    #print(b)
    for i in range(n):
        if(a[i]==-1):
            a[i]=k
    for i in range(1,n):
        d=max(d,abs(a[i]-a[i-1]))
    print(d,k)
   # print(*a)