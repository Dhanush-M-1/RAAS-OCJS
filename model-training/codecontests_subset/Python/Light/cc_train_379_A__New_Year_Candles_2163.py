a, b = [int(x) for x in input().split()]
n = 0
bu = 0
while a:
    n += a
    bu += a % b
    a = a // b
    if not a and bu >= b:
        a = bu // b
        bu = bu % b
print(n)
