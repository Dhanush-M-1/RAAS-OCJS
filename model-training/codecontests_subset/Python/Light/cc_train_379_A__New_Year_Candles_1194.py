a, b = map(int, input().split())
i = a
ost = 0
while a >= b:
    ost = a % b
    a = a // b
    i += a
    a += ost
print(i)
