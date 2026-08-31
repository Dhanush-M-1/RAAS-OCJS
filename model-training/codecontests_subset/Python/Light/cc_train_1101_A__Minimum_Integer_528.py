q = int(input())
for i in range(q):
    l, r, d = map(int, input().split())
    x1 = d
    x2 = ((r) // d + 1) * d
    if x1 < l:
        print(x1)
    else:
        print(x2)