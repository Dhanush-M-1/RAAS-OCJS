n, m = map(int, input().split())

stair = [1]*(n+1)
for i in range(m):
    a = int(input())
    stair[a] = 0

for i in range(2, n+1):
    stair[i] *= (stair[i-1] + stair[i-2])

print(stair[n]%(10**9+7))
