import sys
input = sys.stdin.readline

n, k = map(int, input().split())
a, b, ab = [], [], []
prea, preb, preab = [0], [0], [0]
ans = []

for _ in range(n):
    t1, t2, t3 = map(int, input().split())

    if t2 == t3 == 1:
        ab.append(t1)
    elif t2 == 1:
        a.append(t1)
    elif t3 == 1:
        b.append(t1)

ab.sort()
a.sort()
b.sort()

na, nb, nab = len(a), len(b), len(ab)

if nab + min(na, nb) < k:
    print(-1)
    sys.exit()

if na:
    for x in a:
        prea.append(prea[-1] + x)

if nb:
    for x in b:
        preb.append(preb[-1] + x)

if nab:
    for x in ab:
        preab.append(preab[-1] + x)

if na == 0 or nb == 0:
    if k <= nab:
        print(preab[k])
    else:
        print(-1)
else:
    for x in range(k + 1):
        if nab >= x and na >= k - x and nb >= k - x:
            ans.append(preab[x] + prea[k - x] + preb[k - x])

    if len(ans) == 0:
        print(-1)
    else:
        print(min(ans))