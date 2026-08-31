n = int(input())
point = []
dp=[-10000000000,0,0]
c = 0
for i in range(n):
    a,b = map(int,input().split())
    point.append([a,b])
point.append([10000000000,0])
for i in range(n):
    if dp[0]<point[i][0]-point[i][1]:
        dp[1]+=1
        dp[0]=point[i][0]
    elif point[i][0]+point[i][1]<point[i+1][0]:
        dp[0] = point[i][0]+point[i][1]
        dp[2]+=1
    else :
        dp[0] = point[i][0]
print(dp[1]+dp[2])