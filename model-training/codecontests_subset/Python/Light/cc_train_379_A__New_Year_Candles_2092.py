
a, b = map(int, input().split())
count = 0
mlt = 1

while a > 0:
    a -= 1
    count += 1

    if mlt*b == count:
        a += 1
        mlt += 1

print(count)


