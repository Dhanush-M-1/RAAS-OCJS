l = input().split(' ')
a, b, mori, hour = int(l[0]), int(l[1]), 0, 0

while a > 0 or mori >= b:
    if mori >= b:
        mori -= b
        a += 1
    a -= 1
    hour += 1
    mori += 1

print(hour)
