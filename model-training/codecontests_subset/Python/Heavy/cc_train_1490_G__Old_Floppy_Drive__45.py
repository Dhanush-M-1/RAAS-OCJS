import bisect

t = int(input())

for i in range(t):
    n, m = list(map(int, input().split()))
    a = list(map(int, input().split()))
    x = list(map(int, input().split()))

    pre = 0
    max_e = -float('inf')
    min_e = float('inf')

    s = []

    for j in range(n):
        pre += a[j]
        if pre > max_e:
            max_e = pre
            s.append((pre, j))

    res = []

    for xi in x:
        if pre <= 0:
            index = bisect.bisect_left(s, (xi, 0))
            if index == len(s):
                res.append(-1)
            else:
                res.append(s[index][-1])
        else:
            cur = 0
            loop = 0
            if xi > s[-1][0]:
                loop = ((xi - s[-1][0] - 1) // pre) + 1
                cur += loop * n
            xi -= loop * pre

            index = bisect.bisect_left(s, (xi, 0))
            # print(xi, index, s, s[index], s[index][-1] + cur)
            res.append(s[index][-1] + cur)

    print(*res)

