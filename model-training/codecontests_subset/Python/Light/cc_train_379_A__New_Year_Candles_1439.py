a, b = map(int, input().split())
n = a
c = 0
while n > 0:
    c += 1
    n -= 1
    if c % b == 0:
        n += 1
print(c)
