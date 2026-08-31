t = int(input())
for _ in range(t):
    n = int(input())
    p = list(map(int,input().split()))
    if n < 10:
        print(0,0,0)
        continue
    temp = []
    d = dict()
    for i in range(n):
        if i==0:
            temp.append(p[i])
            d[p[i]] = 1
        else:
            if p[i]==temp[-1]:
                d[p[i]] += 1
            else:
                temp.append(p[i])
                d[p[i]] = 1
    lol = len(temp)
    i = 0
    cg = d[temp[i]]
    cs = 0
    i += 1
    while cs<=cg and i<lol:
        cs += d[temp[i]]
        i += 1
    cb = 0
    tot1 = 0
    tot = cg + cs
    while i<lol:
        tot1 = d[temp[i]]
        i += 1
        if tot + tot1 > n//2:
            #print("why",tot,cb,lol,n//2,p[i])
            break
        else:
            tot = tot + tot1
            cb += tot1
    if cg < cs and cg < cb :
        print(cg,cs,cb)
    else:
        print(0,0,0)


