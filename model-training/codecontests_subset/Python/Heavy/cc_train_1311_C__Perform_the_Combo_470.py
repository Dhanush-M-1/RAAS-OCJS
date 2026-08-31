for q in range(int(input())):
    n,m = map(int,input().split())
    s = input()
    p = sorted(list(map(int,input().split())))
    res = [0]*26
    di = dict()
    iter = 0
    for i in range(m):
        if di.get(p[i],-1) == -1:
            di[p[i]] = 1
            yy = (m-i+1)
            for j in range(iter,p[i]):
                ww = ord(s[j])-97
                res[ww]+=yy
            iter = p[i]

    for i in range(iter,n):
        ww = ord(s[i]) - 97
        res[ww] += 1
    print(*res)







