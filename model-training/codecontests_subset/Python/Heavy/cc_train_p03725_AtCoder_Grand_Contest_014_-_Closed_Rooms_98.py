from collections import deque

H, W, K = map(int, input().split())
A = [[0 for _ in range(W)] for _ in range(H)]
for i in range(H):
    A_i_x = input()
    for j in range(W):
        A[i][j] = A_i_x[j]
        if A_i_x[j] == 'S':
            start_h = i
            start_w = j

dist_from_exit = [[0 for _ in range(W)] for _ in range(H)]
for i in range(H):
    for j in range(W):
        dist_from_exit[i][j] = min(i, j, H - 1 - i, W - 1 - j)

queue = deque()
queue.append([start_h, start_w])
visited = [[-1 for _ in range(W)] for _ in range(H)]
visited[start_h][start_w] = 0
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
dist_left_cand = [dist_from_exit[start_h][start_w]]
while queue:
    h, w = queue.pop()
    for i in range(4):
        if 0 <= h + dy[i] <= H-1 and 0 <= w + dx[i] <= W-1:
            if visited[h + dy[i]][w + dx[i]] == -1 and A[h + dy[i]][w + dx[i]] == '.' and visited[h][w] < K:
                queue.appendleft([h + dy[i], w + dx[i]])
                visited[h + dy[i]][w + dx[i]] = visited[h][w] + 1
                dist_left_cand.append(dist_from_exit[h + dy[i]][w + dx[i]])

dist_left_min = min(dist_left_cand)
print((dist_left_min - 1) // K + 1 + 1)
