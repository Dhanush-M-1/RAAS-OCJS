for t in range(int(input())):
    n = int(input())
    sr = 0
    sd = 0
    fu = 0
    fl = 0

    for i in range(n):
        l = input()
        if i == 0:
            sr = l[1]
        elif i == 1:
            sd = l[0]
        if i == n - 2:
            fu = l[n-1]
        elif i == n - 1:
            fl = l[n-2]
    ans=[]
    #print(sr,sd,fu,fl)
    if fu==fl:
        if sr==fu:
            ans+=[[1,2]]
        if sd==fu:
            ans+=[[2,1]]
    elif fu!=fl:
        if sd==sr:
            if sr == fu:
                ans += [[n-1, n]]
            if sr == fl:
                ans += [[n, n-1]]
        else:
            if sd==fu:
                ans+=[[2,1]]
                ans+=[[n,n-1]]
            elif sd==fl:
                ans += [[2, 1]]
                ans += [[n-1, n]]
    print(len(ans))
    for i in ans:
        print(str(i[0]),str(i[1]))