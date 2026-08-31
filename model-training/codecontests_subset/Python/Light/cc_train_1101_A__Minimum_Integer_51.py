q = int(input())
result = []
for _ in range(q):
    l, r, d = map(int, input().strip().split())
    # between l and r

    if d < l or d > r:
        result.append(d)
        continue
    m = r // d
    res = d * (m + 1)
    result.append(res)

for i in result:
    print(i)
