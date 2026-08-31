for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    i = n // 2
    while 0 < i < n and a[i - 1] == a[i]:
        i -= 1
    if i < 5:
        print(0, 0, 0)
    else:
        g = 0
        s = 1
        while g < s < i:
            g += 1
            while g < i and a[g - 1] == a[g]:
                g += 1
            s = max(s, g * 2 + 1)
            while s < i and a[s - 1] == a[s]:
                s += 1
            if g < s - g and g < i - s:
                print(g, s - g, i - s)
                break
        else:
            print(0, 0, 0)
