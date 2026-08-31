from collections import*
n, m, k = map(int, input(). split())
b = [input() for _ in range(n)]
c = [[[] for z in range(m)] for _ in range(n)]
ans = 0
r = [[0] * m for i in range(n)]
s = 0
q, w = -1, -1


def f(i, y):
    an = []
    if i > 0:
        an.append([i - 1, y])
    if y > 0:
        an.append([i, y - 1])
    if i < n - 1:
        an.append([i + 1, y])
    if y < m - 1:
        an.append([i, y + 1])
    return an


for i in range(n):
    for y in range(m):
        if b[i][y] == '.':
            s += 1
            q = i
            w = y
            for j in f(i, y):
                if b[j[0]][j[1]] == '.':
                    c[i][y].append(j)


def dfs(i, y):
    global ans
    d = deque()
    d.append([i, y])
    ans = 1
    r[i][y] = 1
    while ans != s - k:
        z = d.pop()
        i, y = z[0], z[1]
        r[i][y] = 1
        for x in range(len(c[i][y])):
            if r[c[i][y][x][0]][c[i][y][x][1]] == 0:
                d.append([c[i][y][x][0], c[i][y][x][1]])
                r[c[i][y][x][0]][c[i][y][x][1]] = 1
                ans += 1
                if ans == s - k:
                    break


if not (q == w == -1):
    dfs(q, w)
for i in range(n):
    for y in range(m):
        if b[i][y] == '.' and r[i][y] == 0:
            r[i][y] = 'X'
        else:
            r[i][y] = b[i][y]
for i in range(n):
    print(''.join(r[i]))
