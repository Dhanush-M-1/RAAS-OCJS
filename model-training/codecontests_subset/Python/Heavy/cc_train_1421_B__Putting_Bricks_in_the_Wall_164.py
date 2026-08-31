for t in range(int(input())):
    n=int(input())
    mat=[]
    for i in range(n):
        mat.append(list(input()))
    out=0
    ans=[]
    if mat[0][1]==mat[1][0]:
        if mat[-1][-2]==mat[0][1]:
            out+=1
            ans.append([n,n-1])
        if mat[n-2][n-1]==mat[0][1]:
            out+=1
            ans.append([n-1,n])
    elif mat[n-1][n-2]==mat[n-2][n-1]:
        if mat[0][1]==mat[n-1][n-2]:
            ans.append([1,2])
            out+=1
        if mat[1][0]==mat[n-1][n-2]:
            ans.append([2,1])
            out+=1
    else:
        out=2
        ans.append([1,2])
        if mat[0][1]==mat[n-1][n-2]:
            ans.append([n-1,n])
        else:
            ans.append([n,n-1])
    print(out)
    for i in ans:
        print(*i)