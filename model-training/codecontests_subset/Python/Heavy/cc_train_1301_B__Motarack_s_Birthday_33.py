for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    mn = 10**9 + 1
    mx = -1
    realmx = 0
    realmn = 0
    for i in range(n):
        if arr[i] < 0:
            if i > 0 and arr[i - 1] != -1:
                mx = max(arr[i - 1], mx)
                mn = min(arr[i - 1], mn)
            if i < n - 1 and arr[i + 1] != -1:
                mx = max(arr[i + 1], mx)
                mn = min(arr[i + 1], mn)
        else:
            if i > 0 and arr[i - 1] != -1:
                realmx = max(realmx, abs(arr[i] - arr[i - 1]))
                realmm = min(realmx, abs(arr[i] - arr[i - 1]))
    ans = (mx + mn) // 2
    dist_ans = mx - ans
    if dist_ans >= realmx:
        print(dist_ans, ans)
    else:
        print(realmx - realmn, ans)

