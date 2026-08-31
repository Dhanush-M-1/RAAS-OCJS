inp = lambda : map(int, input().split())
n, m = inp()
lines = [[] for i in range(n + 1)]
for i in range(m):
    x, y = inp()
    lines[x].append(y)
    lines[y].append(x)
color = [-1] * (n + 1)
for j in range(1, n + 1):
    if color[j] != -1:
        continue
    head = 0
    color[j] = 0
    q = [j]
    while head < len(q):
        for i in lines[q[head]]:
            if color[i] == color[q[head]]:
                print(-1)
                quit()
            if color[i] == -1:
                q.append(i)
                color[i] = (color[q[head]] + 1) % 2
        head += 1
a = []
b = []
for i in range(len(color)):
    if color[i] == 0:
        a.append(str(i))
    if color[i] == 1:
        b.append(str(i))
print(len(a))
print(" ".join(a))
print(len(b))
print(" ".join(b))

