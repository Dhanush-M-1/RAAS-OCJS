n = int(input())
x1,h1 = map(int,input().split())
res = [[0,0,0] for i in range(n)]
res[0][0]=1
from sys import stdin
for i in range(1,n):
    x2,h2 = map(int,stdin.readline().split())
    if i==1:
        if h1<x2-x1:res[0][1]=1
    else:
        k=0
        if h1<x2-x1:k=1
        res[i-1][1]=max(res[i-2][0],res[i-2][1],res[i-2][2])+k
    q,w=0,0
    if h2<x2-x1:q=1
    if h2+h1<x2-x1:w=1
    res[i][0]=max(res[i-1][0]+q,res[i-1][1]+w,res[i-1][2]+q)
    res[i][2]=max(res[i-1][0],res[i-1][1],res[i-1][2])
    x1,h1=x2,h2
if n>1:
    res[n-1][1]=max(res[n-2][0],res[n-2][1],res[n-2][2])+1
print(max(res[n-1]))