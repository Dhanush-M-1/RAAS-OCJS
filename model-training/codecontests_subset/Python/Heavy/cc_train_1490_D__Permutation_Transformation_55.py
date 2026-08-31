def rec(l, r, a, ans, d):
    if l > r:
        return
    if l == r:
        ans[l] = d
        return
    ma = -1
    for j in range(l, r + 1):
        if a[j] > ma:
            ma = a[j]
            m = j
    ans[m] = d
    if l < m:
        rec(l, m - 1, a, ans, d + 1)
    if r > m:
        rec(m + 1, r, a, ans, d + 1)
t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    ans = [0] * n
    rec(0, n - 1, a, ans, 0)
    for x in ans:
        print(x, end=' ')
    print()
