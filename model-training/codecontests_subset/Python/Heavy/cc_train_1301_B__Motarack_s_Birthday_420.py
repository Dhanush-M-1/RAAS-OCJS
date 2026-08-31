t = int(input())

for i in range(t):
    n = int(input())
    a = [int(x) for x in input().split()]
    # print(a)
    d = set()
    for i, x in enumerate(a):
        if x == -1:
            if i > 0:
                d.add(a[i-1])
            if i < len(a) - 1:
                d.add(a[i+1])
    # print(list(d))
    d = [x for x in list(d) if x != -1]
    a2 = (min(d) + max(d)) // 2 if d else 0
    a = [x if x != -1 else a2 for x in a]
    print('%d %d' % (max([abs(a[x] - a[x + 1]) for x in range(len(a) - 1) if a[x] != -1 and a[x + 1] != -1]), a2))
