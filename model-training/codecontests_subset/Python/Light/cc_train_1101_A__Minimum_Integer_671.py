q = int(input())

for i in range(q):
    l, r, d = map(int, input().split())
    if l>d:
        print(d)
    elif d>=l and d<=r:
        x = r%d
        x1 = d - x
        n = r + x1
        print(n)
    else:
        print(d)