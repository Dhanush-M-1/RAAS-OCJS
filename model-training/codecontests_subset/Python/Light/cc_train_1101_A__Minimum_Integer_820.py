r = range(int(input()))
for _ in r:
    l, r, d = list(map(int, input().split()))
    result = None
    for i in range(d, l, d):
        if i%d == 0:
            result = i
            break
    if not result:
        rr = r%d
        result = r + (d - rr)
        if result == r:
            result += d
    print(result)
