n = int(input())
x = []
h = []
dx = []
for i in range(n):
    a, b = map(int, input().split())
    x.append(a)
    h.append(b)
if n == 1 or n == 2:
    print(n)
else:
    for j in range(n - 1):
        dx.append(x[j + 1] - x[j])
    m = 2
    for k in range(1, n - 1):
        if h[k] < dx[k - 1]:
            m += 1
        elif h[k] < dx[k]:
            m += 1
            dx[k] -= h[k]
    print(m)