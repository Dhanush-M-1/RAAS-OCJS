
a, b = map(int, input().split())
if 1 <= a <= 1000 and 2 <= b <= 1000:
    i = 0
    j = 1
    c = 0
    while a > 0:
        i += 1
        a -= 1
        c += 1
        if i == b*j and c % b == 0:
            j += 1
            a += 1
            c -= b
    print(i)
