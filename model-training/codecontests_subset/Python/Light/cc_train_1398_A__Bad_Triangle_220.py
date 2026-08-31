for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    mi, mi_idx, ma, ma_idx = 10**10, 0, 0, 0
    for i in range(n):
        if a[i] < mi:
            mi, mi_idx = a[i], i
        if a[i] > ma:
            ma, ma_idx = a[i], i
    ans = [mi_idx+1, ma_idx+1]
    for i in range(n):
        if i == mi_idx or i == ma_idx:
            continue
        if not(mi-ma < a[i] < mi+ma and mi-a[i] < ma < mi+a[i] and ma-a[i] < mi < ma+a[i]):
            ans.append(i+1)
            break
    if len(ans) == 2:
        print(-1)
    else:
        print(*sorted(ans))