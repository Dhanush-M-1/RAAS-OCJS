r=int(input())
if r==1:
    print(1)
else:
    l1 = []
    l2 = []
    for i in range(r):
        x, h = map(lambda x: int(x), input().split())
        l1.append(x)
        l2.append(h)
    c = 0
    w = 2
    for i in range(1, len(l1) - 1):
        d = l1[i] - l1[i - 1] - c
        if d <= l2[i]:
            d1 = l1[i + 1] - l1[i]
            if d1 > l2[i]:
                c = l2[i]
                w += 1
            else:
                c = 0
        else:
            w += 1
            c = 0
    print(w)
