q = int(input())

for i in range(q):
    l, r, d = [int(i) for i in input().split()]
    if l > d or d > r:
        print(d)
    else:
        t = r - d
        x = d + t // d * d + d
        print(x)
