t = int(input())
for _ in range(t):
    ans = True
    n = int(input())
    p_max, c_max = 0, 0
    p = [0] * n
    c = [0] * n
    for i in range(n):
        pp, cc = map(int, input().split())
        p[i], c[i] = pp, cc

    for i in range(n):
        if p[i] < c[i]:
            ans = False
            break
        if p[i] < p_max:
            ans = False
            break
        else:
            p_diff = p[i] - p_max
            p_max = p[i]
        if c[i] < c_max:
            ans = False
            break
        else:
            c_diff = c[i] - c_max
            c_max = c[i]
        if p_diff < c_diff:
            ans = False
            break
        #print(i, p_max, c_max)
    if ans:
        print('YES')
    else:
        print('NO')
