for _ in range(int(input())):
    n = int(input())
    g = []
    for _ in range(n):
        g.append([(num) for num in input()])
    a = g[0][1]
    b = g[1][0]
    p = 0
    c = g[n-1][n-2]
    d = g[n-2][n-1]
    ans = []
    
    if a==b:
        if c==d:
            if c==a:
                p = p + 2 
                ans.append([n-1,n])
                ans.append([n,n-1])
            else:
                p = 0
        elif c!=d:
            if c==a:
                p = p + 1
                ans.append([n,n-1])
            elif a==d:
                p = p + 1 
                ans.append([n-1,n])
    if a!=b:
        if c==d:
            if c==a:
                p = p + 1
                ans.append([1,2])
            elif c==b:
                p = p + 1
                ans.append([2,1])
        elif c!=d:
            if c==a:
                p = p + 2
                ans.append([1,2])
                ans.append([n-1,n])
                
            if c==b:
                p = p + 2
                ans.append([2,1])
                ans.append([n-1,n])
    print(p)
    for i in range(p):
        print(ans[i][0],ans[i][1])
                