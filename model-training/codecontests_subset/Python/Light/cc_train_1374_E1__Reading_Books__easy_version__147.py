from collections import Counter
n, k = map(int, input().split())
dat = [list(map(int, input().split())) for _ in range(n)]
x = [v for v, a, b in dat if a and b]
y = [v for v, a, b in dat if a and not b]
z = [v for v, a, b in dat if not a and b]
x.extend(u + v for u, v in zip(sorted(y), sorted(z)))
if len(x) < k:
    print(-1)
else:
    print(sum(sorted(x)[:k]))