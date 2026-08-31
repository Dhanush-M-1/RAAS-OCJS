for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    mn, mx = int(1e9), 0
    for i in range(n):
        if arr[i] != -1:
            continue
        if (i > 0) and (arr[i - 1] != -1):
            mx = max(mx, arr[i - 1])
            mn = min(mn, arr[i - 1])
        if (i < n - 1) and (arr[i + 1] != -1):
            mx = max(mx, arr[i + 1])
            mn = min(mn, arr[i + 1])
    k = (mx + mn) // 2
    arr = [i if i != -1 else k for i in arr]
    ans = max([abs(arr[i] - arr[i - 1]) for i in range(1, n)])
    print(ans, k)
