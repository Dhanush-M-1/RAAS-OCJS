from bisect import bisect_right

for _ in range(int(input())):
    n, m = map(int,input().split())
    arr = list(map(int,input().split()))
    queries = list(map(int,input().split()))
    cum = [0] * n
    cum[0] = arr[0]
    total = arr[0]
    for i in range(1,n):
        total += arr[i]
        cum[i] = max(cum[i-1], total)
    res = [0] * m
    if total <= 0:
        for i,x in enumerate(queries):
            if x > cum[-1]:
                res[i] = -1
            else:
                j = bisect_right(cum, x-1)
                res[i] = j
    else:
        for i,x in enumerate(queries):
            if x <= cum[-1]:
                j = bisect_right(cum, x-1)
                res[i] = j
            else:
                a = x - cum[-1]
                q = (a + total - 1) // total
                r = x - q * total
                j = bisect_right(cum, r - 1)
                res[i] = n * q + j
    print(*res)