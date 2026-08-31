n, k = map(int, input().split())
a = list(map(int, input().split()))

d = {}
for e in a:
    try:
        d[e] += 1
    except:
        d[e] = 1

min_ = float("inf")
for x in range(200001):
    try:
        c2 = d[x]
    except:
        c2 = 0
    c1, f = 0, False
    for y in sorted(d.keys()):
        c3, c4 = 0, min([d[y], k-c2])
        while x < y:
            y //= 2
            c3 += 1
        if x == y and c3 != 0:
            c1 += c3*c4
            c2 += c4
        if c2 >= k:
            f = True
            break
    if f and c1 < min_:
        min_ = c1

print(min_)
