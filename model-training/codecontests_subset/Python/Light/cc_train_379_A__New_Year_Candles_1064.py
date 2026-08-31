n, m = map(int, input().split())
a, b, c, r = 1, n + 1, 0, 0
while b - a > 0:
    for i in range(a, b):
        if i % m == 0:
            c += 1
    a, b = n + r + 1, n + c + r + 1
    r += c
    c = 0
if (n + r) % m == 0:
    r += 1
print(n + r)