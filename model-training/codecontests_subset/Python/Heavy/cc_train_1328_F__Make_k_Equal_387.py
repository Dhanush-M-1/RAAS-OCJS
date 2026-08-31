n, k = map(int, input().split())
a = [int(i) for i in input().split()]
a.sort()
data = {}
for x in a:
    cur = x
    iterations = 0
    while (cur > 0):
        if data.get(cur) is not None:
            data[cur].append(iterations)
        else:
            data[cur] = [iterations]
        cur = cur // 2
        iterations += 1
    if data.get(0) is not None:
        data[0].append(iterations)
    else:
        data[0] = [iterations]
ans = 100000000000
for key, iters in data.items():
    if (len(iters) >= k):
        s = 0
        for i in range(k):
            s += iters[i]
        ans = min(ans, s)
print(ans)
