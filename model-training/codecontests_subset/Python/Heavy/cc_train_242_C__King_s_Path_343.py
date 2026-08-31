def gcd(x, y):
    if y == 0:
        return x

    return gcd(y, x % y)


# =======================================================
x0, y0, x1, y1 = map(int, input().split(" "))
start = (x0, y0, 0)
end = (x1, y1)
n = int(input())
valid = set()
for i in range(n):
    row, l, h = map(int, input().split())
    for i in range(l, h+1, 1):
        valid.add((row, i))
dx = [0, 0, 1, -1, 1, 1, -1, -1]
dy = [1, -1, 0, 0, 1, -1, 1, -1]
q = [start]
visited = set()
visited.add((start[0], start[1]))
while len(q) > 0:
    current = q[0]
    q.pop(0)
    if current[0] == end[0] and current[1] == end[1]:
        print(current[2])
        exit(0)
    for i in range(0, 8, 1):

        if (current[0]+dx[i], current[1]+dy[i]) in valid and (current[0]+dx[i], current[1]+dy[i]) \
                not in visited:
            q.append((current[0]+dx[i], current[1] + dy[i], current[2] + 1))
            visited.add((current[0]+dx[i], current[1]+dy[i]))

print(-1)