from math import inf
n=int(input())
x=[]
h=[]
for i in range(n):
    a,b=map(int,input().split())
    x.append(a)
    h.append(b)
dp=[[-inf for i in range(3)] for j in range(n)]
dp[0]=[0,1,1]
p=[x[0],x[0],x[0]+h[0]]
for i in range(1,n):
    m=-inf
    for j in range(3):
        if x[i]>p[j]:
            m=max(m,dp[i-1][j])
    dp[i][0]=m
    dp[i][2]=m+1
    m=-inf
    for j in range(3):
        if x[i]-h[i]>p[j]:
            m=max(m,dp[i-1][j])
    dp[i][1]=m+1
    p[0]=x[i]
    p[1]=x[i]
    p[2]=x[i]+h[i]
    
print(max(dp[n-1]))