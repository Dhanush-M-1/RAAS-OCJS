import sys
input = sys.stdin.readline
def multi_input():
    return map(int, input().split())

def array_print(arr):
    print(' '.join(map(str, arr)))



n = int(input())
pos = []
heights = []
for i in range(n):
    p, h = multi_input()
    pos.append(p)
    heights.append(h)

dp = [[0 for i in range(n)] for j in range(2)]
dp[0][0] = 1
dp[1][0] = 0


for i in range(1,n-1):

    if dp[1][i-1] > dp[0][i-1]:

        if heights[i-1] + pos[i-1] < pos[i] - heights[i]:
            dp[0][i] = dp[1][i-1] + 1
            dp[1][i] = dp[1][i-1]

        elif pos[i] + heights[i] < pos[i+1]:
            dp[1][i] = max(dp[0][i-1], dp[1][i-1]) + 1
            dp[0][i] = dp[1][i-1]

        else:
            dp[0][i] = max(dp[0][i-1], dp[1][i-1])
            dp[1][i] = max(dp[0][i-1], dp[1][i-1])


    else:
        if pos[i-1] < pos[i] - heights[i]:
            dp[0][i] = dp[0][i-1] + 1
            dp[1][i] = dp[1][i-1]

        elif pos[i] + heights[i] < pos[i+1]:
            dp[1][i] = max(dp[0][i-1], dp[1][i-1]) + 1
            dp[0][i] = dp[1][i-1]

        else:
            dp[0][i] = max(dp[0][i-1], dp[1][i-1])
            dp[1][i] = max(dp[0][i-1], dp[1][i-1])

# print(dp[0])
# print(dp[1])
if n>1:
    print(max(dp[0][n-2], dp[1][n-2]) + 1)
else:
    print(1)