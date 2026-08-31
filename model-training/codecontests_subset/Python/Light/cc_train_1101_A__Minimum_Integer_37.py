rd = lambda: list(map(int, input().split()))
for _ in range(rd()[0]):
    l, r, d = rd()
    print(d if not (l <= d <= r) else r // d * d + d)