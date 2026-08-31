for _ in range (int(input())):
    a, b, c = map(int, input().split())
    s1 = 0
    if c >= 2:
        c = c // 2
        if b >= c:
            s1 += c * 3
            b = b - c
            if b > 0:
                b = b // 2
                if a >= b:
                    s1 += 3 * b
                else:
                    s1 += 3 * a
        else:
            s1 += 3 * b
    else:
        b = b // 2
        if a >= b:
            s1 += 3 * b
        else:
            s1 += 3 * a
    print(s1)