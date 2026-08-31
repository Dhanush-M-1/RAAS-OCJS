import sys
input = sys.stdin.readline


n = int(input())
a = []

for x in range(n):
    i = input().split()
    a.append((int(i[0]), int(i[1])))

dp = [[-float('inf')] * 3 for x in range(n)]

for x in range(n):
    farleft = a[x][0] - a[x][1]
    farright = a[x][0] + a[x][1]

    if x == 0:
        dp[x][0] = 1
    elif farleft > a[x - 1][0] + a[x - 1][1]:
        dp[x][0] = max(dp[x - 1]) + 1
    elif a[x - 1][0] < farleft:
        dp[x][0] = max(dp[x - 1][:2]) + 1

    if x != 0:
        dp[x][1] = max(dp[x - 1])
    else:
        dp[x][1] = 0

    if x == n - 1 or farright < a[x + 1][0]:
        if x != 0:
            dp[x][2] = max(dp[x - 1]) + 1
        else:
            dp[x][2] = 1
#print(dp)
print(max(dp[-1]))
    
