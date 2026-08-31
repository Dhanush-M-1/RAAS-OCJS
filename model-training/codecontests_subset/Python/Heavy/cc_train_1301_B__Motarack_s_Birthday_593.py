def calc(a, k):
    ret = 0
    prev = -1
    for i in a:
        if i == -1:
            if prev != -1:
                ret = max(ret, abs(k-prev))
            prev = k
        else:
            if prev != -1:
                ret = max(ret, abs(i-prev))
            prev = i
    return ret


t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    lb, ub = 0, 10**9
    while ub - lb > 2:
        k1 = (2*lb + ub) // 3
        k2 = (lb + 2*ub) // 3
        m1 = calc(a, k1)
        m2 = calc(a, k2)
        if m1 == m2:
            lb, ub = k1, k2
        elif m1 < m2:
            ub = k2
        else:
            lb = k1
    mk = [(calc(a, k), k) for k in range(lb, ub+1)]
    m, k = min(mk)
    print(m, k)
