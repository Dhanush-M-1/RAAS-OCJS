for _ in range(int(input())):
    n=int(input())
    mat=[]
    c=0
    for i in range(n):
        mat.append(list(input()))
    
    out=[]
    if mat[1][0]==mat[0][1]:
        par=int(mat[1][0])^1
        if mat[-1][-2]!=str(par):
            c+=1
            out.append((n,n-1))
        if mat[-2][-1]!=str(par):
            c+=1
            out.append((n-1,n))
    elif mat[-1][-2]==mat[-2][-1]:
        par=int(mat[-1][-2])^1
        if mat[1][0]!=str(par):
            out.append((2,1))
            c+=1
        if mat[0][1]!=str(par):
            out.append((1,2))
            c+=1
    else:
        par=0
        if mat[1][0]!=str(par):
            out.append((2,1))
            c+=1
        else:
            out.append((1,2))
            c+=1
        par=1
        if mat[-1][-2]!=str(par):
            c+=1
            out.append((n,n-1))
        if mat[-2][-1]!=str(par):
            c+=1
            out.append((n-1,n))
    print(c)
    for i in out:
        print(*i)