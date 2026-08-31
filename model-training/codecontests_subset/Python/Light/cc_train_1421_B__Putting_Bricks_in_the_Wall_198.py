for _ in range(int(input())):
    n = int(input())
    mat = []
    for i in range(n):
        mat.append(input())
    d = [(1,2),(2,1),(n-1,n),(n,n-1)]
    items = [int(mat[0][1]),int(mat[1][0]),int(mat[-2][-1]),int(mat[-1][-2])]
    ans = []
    if items[:2]==[0,0] or items[2:]==[1,1]:
        for i in range(4):
            if i<2 and items[i]:ans.append(d[i])
            elif i>1 and not items[i]:ans.append(d[i])
    else:
        for i in range(4):
            if i>1 and items[i]:ans.append(d[i])
            elif i<2 and not items[i]:ans.append(d[i])
    print(len(ans))
    for i in ans:
        print(*i)