q = int(input())
for _ in range(q):
    l, r, d = [int(x) for x in input().split()]
    if d < l or d > r:
        print(d)
    else:
        print((r//d+1) * d)
