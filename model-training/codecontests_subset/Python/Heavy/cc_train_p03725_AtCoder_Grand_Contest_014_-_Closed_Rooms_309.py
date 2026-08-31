def dist(r, c):
    return min(r, H - r - 1, c, W - c - 1)

H, W, K = map(int, input().split())
A = [list(input()) for _ in range(H)]

for r in range(H):
    for c in range(W):
        if A[r][c] == 'S':
            sr = r
            sc = c

dxy = [(1, 0), (0, -1), (-1, 0), (0, 1)]
pos = [(sr, sc)]
dic = {(sr, sc): K}
cnt = 0
ans = H * W
i = 0
while i < len(pos):
    r0, c0 = pos[i]
    d0 = dist(r0, c0)
    ans = min(ans, (d0 + K - 1) // K + 1)
    m0 = dic[(r0, c0)]
    if 0 < m0:
        m = m0 - 1
        for (dx, dy) in dxy:
            r = r0 + dy
            c = c0 + dx
            d = dist(r, c)
            if 0 <= r < H and 0 <= c < W and A[r][c] != '#' and (r, c) not in dic:
                pos.append((r, c))
                dic[(r, c)] = m
    i += 1

print(ans)
