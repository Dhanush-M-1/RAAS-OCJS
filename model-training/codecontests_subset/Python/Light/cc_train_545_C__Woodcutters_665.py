n=int(input())
dp=[[0 for i in range(2)] for j in range(n)]
x=[]
h=[]
for i in range(n):
    a,b=map(int,input().split())
    x.append(a)
    h.append(b)
dp[0][0]=1
dp[0][1]=x[0]
x.append(2*10**9+1)
for i in range(1,n):
    if x[i]-h[i]>dp[i-1][1]:
        dp[i][1]=x[i]
        dp[i][0]=dp[i-1][0]+1
    elif x[i]+h[i]<x[i+1]:
        dp[i][1]=x[i]+h[i]
        dp[i][0]=dp[i-1][0]+1
    else:
        dp[i][0]=dp[i-1][0]
        dp[i][1]=x[i]
print(dp[n-1][0])
