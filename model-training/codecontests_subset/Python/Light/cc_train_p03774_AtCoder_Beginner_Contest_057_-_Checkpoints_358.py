(n, _), *d = [list(map(int, s.split())) for s in open(0)]
for i, j in d[:n]:
    l = [abs(x - i) + abs(y - j) for x, y in d[n:]]
    print(l.index(min(l)) + 1)