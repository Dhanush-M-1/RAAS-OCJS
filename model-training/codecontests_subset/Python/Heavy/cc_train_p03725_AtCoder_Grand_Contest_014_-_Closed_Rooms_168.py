import itertools, math, collections, sys
input = sys.stdin.readline
H, W, K = [int(_) for _ in input().split()]
A = [input() for _ in range(H)]
for i, j in itertools.product(range(H), range(W)):
    if A[i][j] == 'S':
        A[i] = A[i][:j] + '.' + A[i][j + 1:]
        break
visited = [[False] * W for _ in range(H)]
ans = float('inf')
Q = collections.deque([[i, j, K]])
while Q:
    h, w, res = Q.popleft()
    if not visited[h][w] and A[h][w] == '.':
        visited[h][w] = True
        ans = min([ans, h, H - 1 - h, w, W - 1 - w])
        if res:
            res -= 1
            if h:
                Q += [[h - 1, w, res]]
            if h < H - 1:
                Q += [[h + 1, w, res]]
            if w:
                Q += [[h, w - 1, res]]
            if w < W - 1:
                Q += [[h, w + 1, res]]
print(1 + math.ceil(ans / K))
