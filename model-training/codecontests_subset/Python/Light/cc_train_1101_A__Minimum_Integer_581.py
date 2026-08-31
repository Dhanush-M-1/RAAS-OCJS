q = int(input())
for i in range(q):
    l, r, d = list(map(int, input().split()))
    if (d < l) or (d > r):
        print(d)
    else:
        print((1 + r // d) * d)
