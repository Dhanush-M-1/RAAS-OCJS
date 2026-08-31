n=int(input())
arr=[]
dp=[[0]*2 for x in range(n)]
for x in range(n):
    arr.append(list(map(int,input().split())))
dp[0][0]=1
dp[0][1]=1
for x in range(1,n):
    dp[x][0]=max(dp[x-1][0]+int(arr[x][0]-arr[x-1][0]>arr[x][1]),dp[x-1][1]+int(arr[x][0]-arr[x-1][0]>arr[x][1]+arr[x-1][1]))
    dp[x][1]=max(dp[x-1][0],dp[x-1][1])+int(x+1>=n or (arr[x+1][0]-arr[x][0]>arr[x][1]))
print(dp[-1][-1])