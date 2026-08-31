a = int(input())
i = 0
while i < a :
    b = int(input())
    c = input().split(" ")
    d = []
    s = 0
    while s < b :
        d.append(int(c[s]))
        s = s + 1
    s = 0
    k = d
    k.sort()
    o = 0
    l = 0
    r = 0
    while s < b :
        if d[s] == k[0] :
            s = s + 1
            o = s
            break
        s = s + 1
    s = 1
    while s < b :
        if d[s] == k[1] :
            s = s + 1
            l = s
            break
        s = s + 1
    s = 0
    while s < b :
        if d[s] == k[-1] :
            s = s + 1
            r = s
            break
        s = s + 1
    if k[0] + k[1] <= k[-1] :
        print(o,l,r)
    else:
        print(-1)
    i = i + 1
