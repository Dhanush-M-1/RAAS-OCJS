import itertools, math, collections, sys
input = sys.stdin.readline
H, W, K = [int(_) for _ in input().split()]
A = [list(input()) for _ in range(H)]
for i, j in itertools.product(range(H), range(W)):
    if A[i][j] == 'S':
        break
Q = collections.deque([[i, j, 0]])
sH = set()
sW = set()
while Q:
    h, w, dist = Q.popleft()
    sH.add(h)
    sW.add(w)
    if dist < K:
        for nh, nw in [[h - 1, w], [h + 1, w], [h, w - 1], [h, w + 1]]:
            if 0 <= nh < H and 0 <= nw < W and A[nh][nw] == '.':
                A[nh][nw] = '#'
                Q += [[nh, nw, dist + 1]]
print(1 + min([
    math.ceil(_ / K)
    for _ in (min(sH), H - 1 - max(sH), min(sW), W - 1 - max(sW))
]))
