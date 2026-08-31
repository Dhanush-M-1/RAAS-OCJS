n, p, w, d = list(map(int, input().split()))

s = 0

if (n * w < p):
    print(-1)
elif (w % d == 0) and (p % d > 0):
    print(-1)
elif (p % w == 0):
    print(' '.join(map(str, [p // w, 0, n - p // w])))
else:
    min_wd = p // (w + d)
    for j in range(min_wd + 1):
        curr = p - j * (w + d)
    
        if (curr % w == 0) and (curr // w + 2 * j <= n):
            print(' '.join(map(str, [curr // w + j, j, n - 2 * j - curr // w])))
            s = 1
            break
        if (curr % d == 0) and (curr // d + 2 * j <= n):
            print(' '.join(map(str, [j, curr // d + j, n - 2 * j - curr // d])))
            s = 1
            break
    if (s == 0):
        print(-1)