t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    m = 10**9
    M = 0
    for i in range(n):
        if a[i] == -1:
            if i > 0:
                if a[i-1] != -1:
                    m = min(a[i-1], m)
                    M = max(a[i-1], M)
            if i < n-1:
                if a[i+1] != -1:
                    m = min(a[i+1], m)
                    M = max(a[i+1], M)
    k = (m+M) // 2
    ans = 0
    for i in range(n):
        if a[i] == -1:
            a[i] = k
    for i in range(n-1):
        ans = max(ans, abs(a[i+1] - a[i]))

    print(ans, k)
