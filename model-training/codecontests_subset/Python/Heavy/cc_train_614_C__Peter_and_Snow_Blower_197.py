import math
n, a, b = map(int, input().split())
vals = []
for _ in range(n):
    u, v = map(int, input().split())
    vals.append((u - a, v - b))
currX, currY = vals[-1]
ans = []
for nextX, nextY in vals:
    ans.append(nextX * nextX + nextY * nextY)
    dx = nextX - currX
    dy = nextY - currY
    if (currX * dx + currY * dy) * (nextX * dx + nextY * dy) < 0:
        val = currX * nextY - nextX * currY
        ans.append((val * val) / (dx * dx + dy * dy))
    currX = nextX
    currY = nextY
print((max(ans) - min(ans)) * math.pi)