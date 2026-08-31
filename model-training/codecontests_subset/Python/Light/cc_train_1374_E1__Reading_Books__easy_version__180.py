n, k = map(int, input().split())
a, b, ab = [], [], []

for _ in range(n):
    it, ia, ib = map(int, input().split())
    if ia == 1 and ib == 1: ab.append(it)
    elif ia == 1: a.append(it)
    elif ib == 1: b.append(it)

a.sort()
b.sort()

nab = [i + j for i, j in zip(a[:min(len(a) + 1, len(b) + 1)], \
        b[:min(len(a) + 1, len(b) + 1)])]

fab = ab + nab
fab.sort()

print(sum(fab[:k]) if k <= len(fab) else -1)