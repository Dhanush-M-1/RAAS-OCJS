from sys import stdin

a, b = map(int, stdin.readline().split())
res, tail = a, 0
while a:
    a, tail = divmod(a + tail, b)
    res += a
print(res)
