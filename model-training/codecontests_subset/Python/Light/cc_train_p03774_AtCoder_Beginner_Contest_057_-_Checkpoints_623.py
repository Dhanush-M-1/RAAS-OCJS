n, m = map(int, input().split())
ab = [list(map(int, input().split())) for _ in [0]*n]
cd = [list(map(int, input().split())) for _ in [0]*m]
for a, b in ab:
    t = 1001001001
    ti = 0
    for i, (c, d) in enumerate(cd):
        e = abs(a-c)+abs(b-d)
        if t > e:
            t = e
            ti = i+1
    print(ti)