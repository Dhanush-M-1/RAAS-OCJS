import itertools, math, collections, sys
input = sys.stdin.readline
H, W, K = [int(_) for _ in input().split()]
A = [input() for _ in range(H)]
for i, j in itertools.product(range(H), range(W)):
    if A[i][j] == 'S':
        A[i] = A[i][:j] + '.' + A[i][j + 1:]
        break
visited = [[False] * W for _ in range(H)]
ans = min([i, H - 1 - i, j, W - 1 - j])
Q = collections.deque([[i, j, K]])
while Q:
    h, w, res = Q.popleft()
    if 0 <= h < H and 0 <= w < W and not visited[h][w] and A[h][w] == '.':
        visited[h][w] = True
        ans = min([ans, h, H - 1 - h, w, W - 1 - w])
        if res:
            res -= 1
            Q += [[h - 1, w, res]]
            Q += [[h + 1, w, res]]
            Q += [[h, w - 1, res]]
            Q += [[h, w + 1, res]]
print(1 + math.ceil(ans / K))
