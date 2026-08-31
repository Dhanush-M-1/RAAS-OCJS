num_p = int(input().strip())
ps = [1]
ps.extend(list(map(int, input().strip().split())))
ps.append(10 ** 6)  # buffer to simplify

xi = 1
xf = 10 ** 6
from math import inf
min_max = inf

for i, p in enumerate(ps[:-1]):
    min_max = min(min_max, max(p - xi, xf - ps[i + 1]))

print(min_max)