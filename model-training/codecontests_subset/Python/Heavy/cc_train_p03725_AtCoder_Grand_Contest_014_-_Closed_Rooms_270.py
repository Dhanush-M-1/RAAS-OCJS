import sys
from collections import deque
readline = sys.stdin.readline

H, W, K = map(int, readline().split())

G = [[2]*(W+2)]

st = (None, None)
for h in range(H):
    g = readline().strip()
    if 'S' in g:
        st = (1+h, 1+g.index('S'))
    
    G.append([2] + [1 if s == '#' else 0 for s in g] + [2])

G.append([2]*(W+2))

DIREC = [(0, -1), (0, 1), (1, 0), (-1, 0)]

Q = deque([st])
INF = 10**9+7
dist = [[INF]*(W+2) for _ in range(H+2)]
for h, w in Q:
    dist[h][w] = 0


Q2 = deque([st])
ans = INF
while Q:
    nh, nw = Q.pop()
    for dh, dw in DIREC:
        fh, fw = nh+dh, nw+dw
        if G[fh][fw]:
            continue
        if dist[fh][fw] > 1 + dist[nh][nw]:
            dist[fh][fw] = 1 + dist[nh][nw]
            if dist[fh][fw] <= K:
                Q2.append((fh, fw))
                if fh == 1 or fh == H or fw == 1 or fw == W:
                    ans = 1
            Q.appendleft((fh, fw))

if ans == INF:
    dist = [[INF]*(W+2) for _ in range(H+2)]
    for h, w in Q2:
        dist[h][w] = 0
    while Q2:
        nh, nw = Q2.pop()
        for dh, dw in DIREC:
            fh, fw = nh+dh, nw+dw
            if G[fh][fw] == 2:
                continue
            if dist[fh][fw] > 1 + dist[nh][nw]:
                dist[fh][fw] = 1 + dist[nh][nw]
                if fh == 1 or fh == H or fw == 1 or fw == W:
                    ans = min(ans, 2+(dist[fh][fw]-1)//K)
                Q2.appendleft((fh, fw))

print(ans)
            
