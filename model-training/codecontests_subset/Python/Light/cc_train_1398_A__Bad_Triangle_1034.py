def bins(lo, hi, a, val):
    while lo < hi:
        mid = (lo+hi) // 2
        if val <= a[mid]:
            return mid
        else:
            lo = mid + 1
    return lo


t = int(input())

for i in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    chk = 1
    s = arr[0] + arr[1]
    idx = bins(2, n-1, arr, s)
    ss = arr[idx]

    if s <= ss:
        print(1, 2, idx+1)
    else:
        print(-1)
