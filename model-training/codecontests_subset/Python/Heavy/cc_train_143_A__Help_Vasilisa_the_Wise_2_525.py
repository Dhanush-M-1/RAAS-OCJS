import sys
r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
a = (d1 + c1 - r2) // 2
b = (d2 + c2 - r2) // 2
c = (c1 + d2 - r1) // 2
d = (c2 + r2 - d2) // 2
e = [a, b, c, d]
if (d1 + c1 - r2) % 2 == 0 and (d2 + c2 - r2) % 2 == 0 and (c1 + d2 - r1) % 2 == 0 and (c2 + r2 - d2) % 2 == 0:
    if a >= 1 and a <= 9 and b >= 1 and b <= 9 and c >= 1 and c <= 9 and d >= 1 and d <= 9:
        if a != b and b != c and c != d and a != c and a != d and b != d:
            print(a, b)
            print(c, d)
            sys.exit()
print(-1)

# Wed Oct 14 2020 15:48:35 GMT+0300 (Москва, стандартное время)
