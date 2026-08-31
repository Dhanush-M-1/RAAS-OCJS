q = int(input())

for w in range(q):
    l, r, d = [int(x) for x in input().split()]


    res = d

    if d < l or d > r:
        print(d)
    else:
        res = (max(r // d, 1) + 1) * d
        print(res)