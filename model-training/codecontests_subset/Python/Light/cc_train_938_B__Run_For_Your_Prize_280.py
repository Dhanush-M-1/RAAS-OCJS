import bisect as bs


n, a = int(input()), list(map(int, input().split()))
m = bs.bisect_left(a, 5 * 10 ** 5 + 1)

if m == n:
    res = a[m - 1] - 1
elif m == 0:
    res = 10 ** 6 - a[0]
else:
    res = max(a[m - 1] - 1, 10 ** 6 - a[m])

print(res)

