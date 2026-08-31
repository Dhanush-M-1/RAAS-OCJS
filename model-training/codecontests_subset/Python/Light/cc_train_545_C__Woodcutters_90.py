
n=int(input())


arr=[]
for i in range(n):
    pair=list(map(int,input().split()))
    arr.append(pair)
if n==1:
    print(1)

else:
    dp=[[0,0,0] for i in range(n)]
    dp[0][1]=1
    if arr[0][0]+arr[0][1]<arr[1][0]:
        dp[0][2]=1
    for i in range(1,n-1):
        
        if arr[i][0]-arr[i][1]>arr[i-1][0]+arr[i-1][1]:
            dp[i][1]=max(dp[i-1])+1
        elif arr[i][0]-arr[i][1]>arr[i-1][0]:
            dp[i][1]=max(dp[i-1][0],dp[i-1][1])+1
        if arr[i][0]+arr[i][1]<arr[i+1][0]:
            dp[i][2]=max(dp[i-1])+1
        
        dp[i][0]=max(dp[i-1])
    print(max(dp[n-2])+1)
        
    




   
    
    
