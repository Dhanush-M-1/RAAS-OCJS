def read():
    return map(int, input().split())

r1, r2 = read()
c1, c2 = read()
d1, d2 = read()

a11 = (r1 + c1 - d2) // 2
a21 = c1 - a11
a22 = d1 - a11
a12 = r1 - a11

if a11 + a12 == r1 and a21 + a22 == r2 and a11 + a21 == c1 and a12 + a22 == c2\
and a11 + a22 == d1 and a21 + a12 == d2 and 1 <= a11 <= 9 and 1 <= a12 <= 9 and\
1 <= a21 <= 9 and 1 <= a22 <= 9 and len({a11, a12, a21, a22}) == 4:
    print(a11, a12)
    print(a21, a22)
else:
    print(-1)

