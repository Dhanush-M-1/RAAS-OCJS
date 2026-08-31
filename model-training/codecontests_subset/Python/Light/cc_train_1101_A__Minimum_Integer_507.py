for _ in range(int(input())):
    l, r, d = map(int, input().split())
    d2 = d
    if(d >= l and d <= r):
        d = (d + r) - (d + r) % d
    print(d)
