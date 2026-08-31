q = int(input())
for i in range(q):
    l, r, d = [int(z) for z in input().split()]
    x = d
    if l <= x <= r:
        x = r + 1
        xmd = x % d
        x += ((d-xmd) if xmd else 0)
    print(x)
