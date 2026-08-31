import sys

n, k = map(int, input().split())
a = []
b = []
g = []
for i in range(n):
    t, x, y = map(int, input().split())
    if x and y:
        a.append(t)
    elif x:
        g.append(t)
    elif y:
        b.append(t)
a.sort()
b.sort()
g.sort()
t = 0
i = 0
j = 0
for o in range(k):
    if i < len(a) and j < min(len(b), len(g)):
        if a[i] < g[j] + b[j]:
            t += a[i]
            i += 1
        else:
            t += g[j] + b[j]
            j += 1
    elif i < len(a):
        t += a[i]
        i += 1
    elif j < min(len(b), len(g)):
        t += g[j] + b[j]
        j += 1
    else:
        print(-1)
        sys.exit(0)
print(t)