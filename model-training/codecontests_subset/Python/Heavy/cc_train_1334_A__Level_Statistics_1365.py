from collections import defaultdict as df
from sys import stdin,stdout
t=int(input())
for ii in range(t):
    n=int(stdin.readline())
    c=[]
    flag=0
    for i in range(n):
        a,b=list(map(int,stdin.readline().split()))
        c.append((a,b))
    prev=c[0][0]
    prev1=c[0][1]
    if n==1:
        if c[0][0]<c[0][1]:
            print('NO')
        else:
            print('YES')
        continue
    if c[0][0]<c[0][1]:
        print('NO')
        continue
    for i in range(1,n):
        if c[i][0]-c[i-1][0]<c[i][1]-c[i-1][1]:
            flag=1
            break
        elif c[i][0]<c[i-1][0]:
            flag=1
            break
        elif c[i][1]<c[i-1][1]:
            flag=1
            break
        
    if flag==1:
        print('NO')
    else:
        print('YES')
            