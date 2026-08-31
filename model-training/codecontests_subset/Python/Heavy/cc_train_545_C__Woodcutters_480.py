n = int(input())
x = []
h = []
f = []
for i in range(0, n):
    f.append([0, 0, 0])
for i in range(0, n):
    a, b = map(int, input().split())
    x.append(a)
    h.append(b)
f[0][0] = 0
f[0][1] = f[0][2] = 1
for i in range(1, n):
    f[i][0] = max(f[i - 1][0], f[i - 1][1])
    f[i][2] = max(f[i - 1][0], f[i - 1][1]) + 1
    if (x[i - 1] + h [i - 1] < x[i]):
        f[i][0] = max(f[i][0], f[i - 1][2])
        f[i][2] = max(f[i][2], f[i - 1][2] + 1)
    if (x[i] - h[i] > x[i - 1]):
        f[i][1] = max(f[i - 1][0], f[i - 1][1]) + 1
    if (x[i] - h[i] > x[i - 1] + h [i - 1]):
        f[i][1] = max(f[i - 1][2] + 1, f[i][1])

print(max(max(f[n - 1][0], f[n - 1][1]), f[n - 1][2]))