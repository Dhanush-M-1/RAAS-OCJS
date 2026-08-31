q = int(input())

for _ in range(q):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
        continue
    dt = d*((r-d)//d)
    while dt > r:
        dt -= d
    while dt <= r:
        dt += d
    print(dt)