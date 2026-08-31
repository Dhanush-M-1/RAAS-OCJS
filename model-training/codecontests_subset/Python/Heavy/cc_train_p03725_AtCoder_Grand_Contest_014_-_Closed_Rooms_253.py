from collections import deque
import math
h, w, k = [int(item) for item in input().split()]
field = ["O" * (w+2)]
for i in range(h):
    line = "O" + input().rstrip() + "O"
    field.append(line)
    if "S" in line:
        start = [i+1, line.index("S"), 0]
field.append("O" * (w+2))

dq = deque()
dq.append(start)
visited = [[0] * (w+2) for _ in range(h+2)]
visited[start[0]][start[1]] = 1
closest = 10**3 
while dq:
    x, y, d = dq.popleft()
    closest = min(closest, min(x-1, y-1, h-x, w-y))
    if closest == 0:
        break
    d += 1
    for dx, dy in [[1,0], [0,1], [-1,0], [0,-1]]:
        if field[x+dx][y+dy] == "." and visited[x+dx][y+dy] == 0 and d <= k:
            dq.append([x+dx, y+dy, d])
            visited[x+dx][y+dy] = 1
print(1 + int(math.ceil(closest / k)))