r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
flag = 0
for a in range(1, 10):
    for b in range(1, 10):
        for c in range(1, 10):
            for d in range(1, 10):
                if a + b == r1 and c + d == r2 and a + d == d1 and b + c == d2 and a + c == c1 and b + d == c2 and a != b and a != c and a != d and b != c and b != d and c != d:
                    print(a, b)
                    print(c, d)
                    flag = 1
                    break
            if flag:
                    break
        if flag:
                break
    if flag:
            break
else:
    print(-1)
# Fri Oct 16 2020 18:40:37 GMT+0300 (Москва, стандартное время)
