from math import *
import sys
input=sys.stdin.readline
t=int(input())
while t>0:
    t-=1
    n=int(input())
    a=[int(x) for x in input().split()]
    flag=0
    for i in range(n):
        if a[i]==0 and 0<i<n-1:
            flag=1
            break
    if flag==1:
        print("No")
        continue
    dp=[[0,0] for i in range(n+1)]
    flag=[0,0]
    dp[0][0]=min(n-1,a[0])
    dp[0][1]=0
    for i in range(1,n):
        dp[i][0]=min(dp[i-1][0]-1,a[i])
        if dp[i][0]<0:
            flag[0]=2
        if dp[i-1][1]+1>a[i] and flag[1]==0:
            flag[1]=1
            dp[i-1][1]=max(dp[i-1][1],a[i-1])
            dp[i][1]=min(dp[i-1][1]-1,a[i])
            if dp[i][1]<0:
                flag[1]=2
        elif dp[i-1][1]+1<=a[i] and flag[1]==0:
            dp[i][1]=dp[i-1][1]+1
        elif flag[1]==1:
            dp[i][1]=min(dp[i-1][1]-1,a[i])
            if dp[i][1]<0:
                flag[1]=2
        if flag==[2,2]:
            break

    if flag==[2,2]:
        print("No")
    else:
        print("Yes")