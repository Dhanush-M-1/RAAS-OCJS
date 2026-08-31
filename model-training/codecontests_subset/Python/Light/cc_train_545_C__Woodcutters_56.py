def solve(x, h):
    n = len(x)
    res = 1
    left = x[0]
    for i in range(1, n):
        if left < x[i] - h[i]:
            left = x[i]
            res += 1
        elif i == n - 1 or x[i] + h[i] < x[i + 1]:
            left = x[i] + h[i]
            res += 1
        else:
            left = x[i]
    return res


n = int(input())
x, h = [], []
for i in range(n):
    xi, hi = map(int, input().split())
    x.append(xi)
    h.append(hi)
print(solve(x, h))