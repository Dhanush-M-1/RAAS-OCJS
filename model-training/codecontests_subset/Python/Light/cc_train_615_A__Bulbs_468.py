n, m = map(int, input().split())
se = set([])
for i in range(n):
    L = list(map(int, input().split()))
    L = L[1:]
    for l in L:
        se.add(l)
if len(se) == m:
    print("YES")
else:
    print("NO")
