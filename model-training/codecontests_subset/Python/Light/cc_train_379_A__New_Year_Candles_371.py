a, b = [int(x) for x in input().split()]
res = 0

while a >= b:
    res += b
    a -= b
    a += 1
print(res + a)
