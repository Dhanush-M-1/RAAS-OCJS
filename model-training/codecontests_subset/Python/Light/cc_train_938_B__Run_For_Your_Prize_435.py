from itertools import chain
n = int(input())
ps = chain(map(int, input().split()), [10**6])
p = 1
ans = None
for q in ps:
    t = max(p - 1, 10**6 - q)
    ans = min(t, ans) if ans is not None else t
    p = q
print(ans)
