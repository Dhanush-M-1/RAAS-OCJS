test = int(input())
for _ in range(test):
    n = int(input())
    mat = []
    for i in range(n):
        mat.append(list(input()))
    
    a = int(mat[-1][-2])

    b = int(mat[-2][-1])

    c = int(mat[0][1])

    d = int(mat[1][0])


    ans = []
    if a==b:
        ans = []
        if c==a:
            ans.append((1, 2))
        
        if d==a:
            ans.append((2, 1))
    
    elif c==d:
        if c==a:
            ans.append((n, n-1))
        
        if c==b:
            ans.append((n-1, n))

    else:
        if a!=c:
            ans.append((n, n-1))
            ans.append((1, 2))
        
        else:
            ans.append((n, n-1))
            ans.append((2, 1))

    print(len(ans))
    for x, y in ans:
        print(x, y)