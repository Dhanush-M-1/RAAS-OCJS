n=int(input())
trees=[]
for i in range(n):
    trees.append(list(map(int,input().split())))
trees.sort()
if n==1:
    print(1)
else:
    dp=[[0 for i in range(3)] for j in range(n)]
    dp[0][0]=1
    dp[0][1]=1
    for i in range(1,n-1):
        if trees[i][0]-trees[i][1]>trees[i-1][0]+trees[i-1][1]:
            dp[i][0]=max(dp[i-1])+1
        elif trees[i][0]-trees[i][1]>trees[i-1][0]:
            dp[i][0]=max(dp[i-1][0],dp[i-1][2])+1
        if trees[i][0]+trees[i][1]<trees[i+1][0]:
            dp[i][1]=max(dp[i-1])+1
        dp[i][2]=max(dp[i-1])
    print(max(dp[n-2])+1)


