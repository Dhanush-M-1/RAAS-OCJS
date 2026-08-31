from itertools import accumulate
from operator import itemgetter

n, d = map(int, input().split())
aaa = list(map(int, input().split()))
costs_l = [(-i * d + a, i) for i, a in enumerate(aaa)]
costs_r = [(i * d + a, i) for i, a in enumerate(aaa)]

costs_l = list(accumulate(costs_l, min))
costs_r = list(accumulate(reversed(costs_r), min))
costs_r.reverse()

hubs = set(map(itemgetter(1), costs_l))
hubs.intersection_update(map(itemgetter(1), costs_r))
hubs.add(0)
hubs.add(n - 1)
hubs = sorted(hubs)

ans = sum(aaa) - aaa[-1]
s = hubs[0]
for t in hubs[1:]:
    cls = costs_l[s][0]
    crt = costs_r[t][0]
    ans += crt - s * d
    ans += sum(min(cls + i * d, crt - i * d) for i in range(s + 1, t))
    s = t
print(ans)
