t = int(input())
inf, minf = 10**18, -10**18
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    min_n, max_n = inf, minf
    ans = 0
    for i in range(n):
        if a[i] == -1:
            if i+1 < n and a[i+1] > -1:
                min_n = min(min_n, a[i+1])
                max_n = max(max_n, a[i+1])
            if 0 <= i-1 and a[i-1] > -1:
                min_n = min(min_n, a[i-1])
                max_n = max(max_n, a[i-1])
        elif i+1 < n and a[i+1] != -1:
            ans = max(ans, abs(a[i] - a[i+1]))

    if max_n == minf:
        print(0, 0)
    else:
        x = (max_n + min_n) // 2
        print(max(max_n - x, x - min_n, ans), x)
