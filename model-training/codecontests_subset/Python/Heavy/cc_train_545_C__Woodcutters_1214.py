def knock(n, positions, heights):
    dp=[[0 for i in range(n)] for ja in range(3)]
    
    dp[0][0]=1
    dp[1][0]=0
    dp[2][0]=0
    
    if n>1 and positions[0]+heights[0]<positions[1] or n==1:
        dp[2][0]=1
        
    for i in range(1,n):
        if (positions[i]-heights[i])>positions[i-1]:
            if (positions[i-1]+heights[i-1])<(positions[i]-heights[i]):
                dp[0][i]=1+max(dp[0][i-1], dp[1][i-1], dp[2][i-1])
            else:
                dp[0][i]=1+max(dp[0][i-1], dp[1][i-1])
                
        dp[1][i]=max(dp[0][i-1], dp[1][i-1], dp[2][i-1])
        
        if (i==n-1) or ((positions[i]+heights[i])<positions[i+1]):
            dp[2][i]=1+max(dp[0][i-1], dp[1][i-1], dp[2][i-1])
            
    return max(dp[0][n-1], dp[1][n-1], dp[2][n-1])
    
n=int(input())
p=[]
h=[]
for i in range(n):
    x, y=input().split()
    p.append(int(x))
    h.append(int(y))
print(knock(n, p, h))