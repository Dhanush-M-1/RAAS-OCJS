r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

gems = [i for i in range(1, 10)]

required_sum = r1 + r2 + c1 + c2 + d1 + d2
if required_sum % 3 == 0:
    sum_to = required_sum / 3
    for i in range(1, 10):
        a = r1 - i
        b = c1 - i
        c = r2 - b
        if a in gems and b in gems and c in gems and len({i, a, b, c}) == 4:
            if i + c == d1 and a + b == d2 and i + a == r1 and b + c == r2 and i + b == c1 and a + c == c2:
                print(i, a)
                print(b, c)
                exit()
    print(-1)
else:
    print(-1)
