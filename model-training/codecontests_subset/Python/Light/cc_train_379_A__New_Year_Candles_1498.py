a, b = list(map(int, input().split()))
n = 0
f = 0
while a > 0:
    a -= 1
    n += 1
    f += 1
    if f >= b:
        f -= b
        a += 1
print(n)
