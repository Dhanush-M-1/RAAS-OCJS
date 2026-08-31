t = int(input())
for j in range(t):
    n = int(input())
    P = list(map(int, input().split()))
    if n < 5:
        print(0, 0, 0)
    else:
        g = 0
        s = 0
        b = 0
        m = P[0]
        i = 0
        while i < n and P[i] == m:
            g += 1
            i += 1
        while i < n and s <= g:
            s += 1
            i += 1
        m = P[i - 1]
        while i < n and P[i] == m:
            s += 1
            i += 1
        while i < n and b <= g:
            b += 1
            i += 1
        m = P[i - 1]
        while i < n and P[i] == m:
            b += 1
            i += 1
        m = P[i - 1]
        k = 0
        while i < n // 2 + 1:
            if P[i] == m:
                i += 1
                k += 1
            else:
                b += k
                m = P[i]
                k = 1
                i += 1
        if g + b + s > n // 2 or g >= b or g >= s:
            print(0, 0, 0)
        else:
            print(g, s, b)
