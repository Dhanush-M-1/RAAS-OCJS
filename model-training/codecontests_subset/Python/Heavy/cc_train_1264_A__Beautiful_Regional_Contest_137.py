for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    g, s, b = 0, 0, 0
    p = n//2 - 1

    while p > 0 and a[p] == a[n//2]:
        p -= 1

    i = 1
    g = 1
    b = 1
    while i < p and a[i] == a[0]:
        i += 1
        g += 1
        b += 1
    b += 1
    i = p - g
    p = i - 1
    while p > g and a[p] == a[i]:
        p -= 1
        b += 1

    s = p - g + 1
    # print("temp", g, s, b)
    if g > 0 and s > 0 and b > 0 and g < s and g < b:
        print(g, s, b)
    else:
        print(0, 0, 0)

