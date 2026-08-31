t = int(input())
for j in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    m_ras = 0
    mi = float("inf")
    ma = -1
    for i in range(n - 1):
        if a[i] == -1:
            if a[i + 1] != -1:
                mi = min(mi, a[i + 1])
                ma = max(ma, a[i + 1])
        else:
            if a[i + 1] == -1:
                mi = min(mi, a[i])
                ma = max(ma, a[i])
            else:
                m_ras = max(abs(a[i] - a[i + 1]), m_ras)
    if ma == -1:
        print(0, 1)
    else:
        ans = (ma + mi) // 2
        print(max(ma - ans, ans - mi, m_ras), ans)
