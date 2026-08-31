a, b = map(int, input().split())
c, t = 0, 0
while a > 0:
    c += a
    t += a
    a = c // b
    c -= a * b
print(t)