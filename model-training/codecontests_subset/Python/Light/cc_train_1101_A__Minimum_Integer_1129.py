q = int(input())
for q in range(0, q):
    k = [int(a) for a in input().split()]
    l = k[0]
    r = k[1]
    d = k[2]
    if d < l or d > r:
        x = d
    else:
        x = r - (r % d) + d
    print(x)
