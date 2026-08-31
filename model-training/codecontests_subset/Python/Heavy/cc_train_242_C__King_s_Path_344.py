from collections import deque

x_0, y_0, x_1, y_1 = list(map(int, input().split()))

n = int(input())

g = {}

for _ in range(n):
    r, a, b = list(map(int, input().split()))
    # all the valid cols have value -1
    for i in range(a, b + 1):
        g[(r, i)] = -1

g[(x_0, y_0)] = 0

q = deque([(x_0, y_0)])

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

while len(q) != 0:
    current = q.popleft()

    for i in range(8):
        neigbor = (current[0] + dx[i], current[1] + dy[i])
        if neigbor in g and g[neigbor] == -1:
            q.append(neigbor)
            g[neigbor] = g[current] + 1

print(g[(x_1, y_1)])


