i = 0
t = int(input())

while i < t:
    n = int(input())
    temp = n

    if n == 0:
        print(-1)
        i += 1
        continue
    elif n == 1:
        print(0)
        i += 1
        continue

    c2, c3 = 0, 0
    while temp % 2 == 0:
        c2 += 1
        temp /= 2
    while temp % 3 == 0:
        c3 += 1
        temp /= 3

    if temp != 1:
        print(-1)
        i += 1
        continue

    tem = n
    pas = 0
    if c3 > c2:
        # 3 3 2

        # insert same number of 2's
        pas += c3 - c2
        tem = n * (2 ** (c3-c2))

        # get rid of it all
        pas += c3
        tem = n / (6 ** (c3))
    elif c2 > c3:
        # 2 2 3 (cant get rid of 2)
        print(-1)
        i += 1
        continue
    else:
        # 2 2 3 3
        pas += c2
        tem = n / (6 ** (c2))

    print(pas)
    i += 1
