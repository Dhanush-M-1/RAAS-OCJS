for _ in range(int(input())):
    n = int(input())
    l = [int(x) for x in input().split()]

    m1, m2 = -1, 10 ** 9 + 1

    for x in l:
        if x == -1:
            continue
        if x > m1:
            m1 = x
        if x < m2:
            m2 = x

    if m1 == -1 and m2 == 10 ** 9 + 1:
        print(0, 0)
        continue

    m3, m4 = -1, 10 ** 9 + 1
    now = 0

    for x in range(1, n):
        if l[x - 1] == l[x] == -1:
            continue

        if l[x - 1] != -1 and l[x] != -1:
            continue

        if l[x - 1] == -1:
            now = l[x]
        else:
            now = l[x - 1]

        if m3 < now:
            m3 = now
        if m4 > now:
            m4 = now

    k = (m3 + m4) // 2
    num = 0

    for x in range(n):
        if l[x] == -1:
            l[x] = k

    for x in range(1, n):
        now = abs(l[x] - l[x - 1])
        if now > num:
            num = now

    print(num, k)