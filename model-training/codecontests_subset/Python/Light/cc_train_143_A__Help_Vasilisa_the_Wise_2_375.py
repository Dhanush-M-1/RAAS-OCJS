r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
d = int(((c2 + d1)-r1) / 2)
c = int(r2 - d)
a = int(d1 - d)
b = int(c2 - d)
# print(a, b, c, d)
if a == b or a == c or a == d or b == c or b == d or c == d or\
        a < 1 or b < 1 or c < 1 or d < 1 or\
        a > 9 or b > 9 or c > 9 or d > 9 or\
        a + c != c1 or b + d != c2 or a + b != r1 or c + d != r2:
    print('-1')
else:
    print(a, b)
    print(c, d)