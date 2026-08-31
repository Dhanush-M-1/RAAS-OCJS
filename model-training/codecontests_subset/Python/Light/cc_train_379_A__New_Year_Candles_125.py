a, b = [int(i) for i in input().split()]

c, s, k = 0, a, 0
while s != 0:
    s -= 1
    k += 1
    if k == b:
        s += 1
        k = 0
    c += 1

print(c)
