for t in range(int(input())):
    n = int(input())
    tmp = [int(i) for i in input().split()]
    ar = []
    ls = -1
    cnt = 0
    for i in tmp:
        if (ls != i):
            ls = i
            ar.append(cnt)
            cnt = 0
        if (ls == i): cnt += 1
    ar.append(cnt)
    # print(">>",ar)
    i = 2
    g = ar[1]
    s = 0
    b = 0
    while (s <= g and i < len(ar)):
        s += ar[i]
        i += 1
    while (b <= g and i < len(ar)):
        b += ar[i]
        i += 1
    while (i < len(ar) and g+s+b+ar[i] <= n/2):
        b += ar[i]
        i += 1
    if (g+s+b <= n/2 and g < s and g < b): print(g,s,b)
    else: print(0,0,0)