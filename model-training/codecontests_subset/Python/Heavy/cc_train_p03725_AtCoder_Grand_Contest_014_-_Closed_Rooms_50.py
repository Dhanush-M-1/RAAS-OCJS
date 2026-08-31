import itertools, math, collections, sys
input = sys.stdin.readline
H, W, K = [int(_) for _ in input().split()]
A = [list(input()) for _ in range(H)]
for h, w in itertools.product(range(H), range(W)):
    if A[h][w] == 'S':
        break
visited = A
res = K - 1
Q = collections.deque([[h - 1, w, res], [h + 1, w, res], [h, w - 1, res],
                       [h, w + 1, res]])
sH = set([h])
sW = set([w])
while Q:
    h, w, res = Q.popleft()
    if 0 <= h < H and 0 <= w < W and A[h][w] == '.' and visited[h][w] != '#':
        visited[h][w] = '#'
        sH.add(h)
        sW.add(w)
        if res:
            res -= 1
            Q += [[h - 1, w, res], [h + 1, w, res], [h, w - 1, res],
                  [h, w + 1, res]]
print(1 +
      math.ceil(min([min(sH), H - 1 - max(sH),
                     min(sW), W - 1 - max(sW)]) / K))
