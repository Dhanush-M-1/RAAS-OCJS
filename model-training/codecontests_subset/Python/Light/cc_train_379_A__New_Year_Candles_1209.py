a, b = [int(x) for x in input().split()]
h = 0
while a >= b:
    h += b
    a += 1 - b
print(h + a)
