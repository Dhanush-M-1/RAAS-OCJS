n = int(input())
xs = [0] * n
hs = [0] * n
ls = [1] * n
rs = [1] * n

for i in range(n):
    xs[i], hs[i] = map(int, input().split())

if n > 1 and (xs[1] - xs[0] <= hs[0]):
    rs[0] = 0

for i in range(1, n):
    rs[i] = max(rs[i - 1], ls[i - 1])
    if (i == n - 1) or (xs[i + 1] - xs[i] > hs[i]):
        rs[i] += 1

    if (xs[i] - xs[i - 1] - hs[i - 1] > hs[i]):
        ls[i] = max(rs[i - 1] + 1, ls[i - 1] + 1)
    elif (xs[i] - xs[i - 1] > hs[i]):
        ls[i] = max(rs[i - 1], ls[i - 1] + 1)
    else:
        ls[i] = max(rs[i - 1], ls[i - 1])

print(max(rs[-1], ls[-1]))
