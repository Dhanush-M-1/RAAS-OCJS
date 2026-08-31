from math import ceil

for _ in range(int(input())):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))

    s = sum(a)
    mpfa = [0] * n
    mpfi = 0
    pf = mpfa[0] = a[0]
    for i in range(1, n):
        pf += a[i]
        if pf > mpfa[i - 1]:
            mpfi = i
            mpfa[i] = pf
        else:
            mpfa[i] = mpfa[i - 1]

    ans = []
    xli = map(int, input().split())
    for x in xli:
        if x <= mpfa[-1]:
            # binary search
            low = 0
            high = n - 1
            while low < high:
                mid = (low + high) // 2
                if mpfa[mid] >= x:
                    high = mid
                else:
                    low = mid + 1
            ans.append(high)
            continue
        elif s <= 0:
            ans.append(-1)
        else:
            iters = ceil((x - mpfa[-1]) / s)
            # binary search
            low = 0
            high = n - 1
            while low < high:
                mid = (low + high) // 2
                if mpfa[mid] >= (x - s * iters):
                    high = mid
                else:
                    low = mid + 1
            ans.append(iters * n + high)
    print(*ans)
