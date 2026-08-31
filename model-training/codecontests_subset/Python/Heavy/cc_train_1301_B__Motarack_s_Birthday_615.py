import math

n = int(input())
for i in range(n):
    input()
    arr = list(map(int, input().split()))
    mn = 9999999999
    mx = -1
    mxres = -1
    for g in range(1, len(arr) - 1):
        if arr[g] == -1:
            continue
        if arr[g - 1] == -1 or arr[g + 1] == -1:
            mn = min(mn, arr[g])
            mx = max(mx, arr[g])
        if arr[g - 1] != -1:
            mxres = max(mxres, abs(arr[g] - arr[g - 1]))
        if arr[g + 1] != -1:
            mxres = max(mxres, abs(arr[g] - arr[g + 1]))
    if arr[0] != -1 and arr[1] == -1:
        mn = min(mn, arr[0])
        mx = max(mx, arr[0])
    if arr[-1] != -1 and arr[-2] == -1:
        mn = min(mn, arr[-1])
        mx = max(mx, arr[-1])
    if arr.count(-1) == len(arr):
        print(0, 0)
        continue
    print(max(mxres, math.ceil((mx - mn) / 2)), math.ceil((mn + mx) / 2))
