a, b = [int(x) for x in input().split()]
k = 0
d = 0
while (a > 0):
    k += a
    d += a
    a = d // b
    d %= b
print(k)