for _ in range(int(input())):
    n=int(input())
    mat=[]
    for i in range(n):
        mat.append(list(input()))

    a=int(mat[0][1])
    b=int(mat[1][0])
    c=int(mat[n-1][n-2])
    d=int(mat[n-2][n-1])

    change=[]

    if a==b:
        if c==d and c!=a:
            do=1
        elif c==d and c==a:
            change.append([n-1,n-2])
            change.append([n-2,n-1])
        elif c!=d:
            if c==a:
                change.append([n-1,n-2])
            else:
                change.append([n-2,n-1])
    elif c==d:
        if a==c:
            change.append([0,1])
        else:
            change.append([1,0])

    else:
        if a!=0:
            change.append([0,1])
        else:
            change.append([1,0])
        if c!=1:
            change.append([n-1,n-2])
        else:
            change.append([n-2,n-1])

    print(len(change))
    for i in change:
        print(i[0]+1,i[1]+1)