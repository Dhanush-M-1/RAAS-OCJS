def test(n,p) :
    p.sort()
    cost = 0
    prevd = 0
    prevr = 1
    prevc = 1
    for i in range(n) :
        (r,c) = p[i]
        d = r-c
        if prevd == d :
            if d%2 :
                cost += 0
            else :
                cost += (r-prevr)
        else :
            cost += d//2-prevd//2
        prevr = r
        prevd = d
    return cost

for kT in range(int(input())) :
    n = int(input())
    r = list(map(int,input().split()))
    c = list(map(int,input().split()))
    p = [(r[i],c[i]) for i in range(n)]
    print(test(n,p))