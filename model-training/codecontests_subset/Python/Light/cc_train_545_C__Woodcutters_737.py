n = int(input())
ts = []
for _ in range(n):
    ts.append(tuple(map(int, input().split())))
ts = sorted(ts, key=lambda e: e[0])
min_occ = -float('inf')
n = 0
for i, (p, h) in enumerate(ts):
    try:
        if p - h > min_occ:
            n += 1
            min_occ = p
        elif p + h < ts[i + 1][0]:
            n += 1
            min_occ = p + h
        else:
            min_occ = p
    except IndexError:
        n += 1
print(n)
