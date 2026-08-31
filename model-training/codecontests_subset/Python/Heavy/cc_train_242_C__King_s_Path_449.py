from collections import deque
import sys
input = sys.stdin.readline

xadj = [0, 0, -1, 1, -1, -1, 1, 1]
yadj = [1, -1, 0, 0, -1, 1, -1, 1]
res, vis = set(), dict()
x0, y0, x1, y1, = map(int, input().split())
n = int(input())
for seg in range(n):
    r, a, b, = map(int, input().split())
    for c in range(a, b+1):
        res.add((r, c))

pnts = deque()
pnts.append((x0, y0, 0))
vis[(x0, y0)] = 0
while len(pnts) > 0:
    cur = pnts.popleft()
    for i in range(8):
        pos = (cur[0] + xadj[i], cur[1] + yadj[i])
        if pos in res and pos not in vis:
            pnts.append((pos[0], pos[1], cur[2] + 1))
            vis[pos] = cur[2] + 1
print(vis[(x1, y1)] if (x1, y1) in vis else -1)
