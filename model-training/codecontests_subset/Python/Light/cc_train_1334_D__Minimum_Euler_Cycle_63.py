import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n, l, r = map(int, input().split())
    lb, ub = 0, n
    while ub - lb > 1:
        m = (lb + ub) // 2
        if m * (2*n-m-1) < l:
            lb = m
        else:
            ub = m
    i = ub
    s = lb * (2*n-lb-1) + 1
    j = (l - s + 1) // 2 + i
    ans = []
    for k in range(l, r+1):
        if i == n:
            i = 1
        if (k - s) % 2 == 0:
            ans.append(i)
            j += 1
        else:
            ans.append(j)
            if j == n:
                s = k + 1
                i += 1
                j = i
    print(*ans)

