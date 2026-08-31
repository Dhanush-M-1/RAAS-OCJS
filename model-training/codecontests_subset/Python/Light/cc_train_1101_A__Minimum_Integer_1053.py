for _ in range(int(input())):
    l, r, d = list(map(int, input().split()))
    res = d
    if l <= res <= r:
        res = d * (r//d) + d
    print(res)
