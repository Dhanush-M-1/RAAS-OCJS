for _ in range(int(input())):
    n = int(input())
    mat = []
    for i in range(n):
        mat.append(list(map(str,input())))
    ans = []
    tl = [[0,1],[1,0]]
    tr = [[n-1,n-2],[n-2,n-1]]
    if mat[tl[0][0]][tl[0][1]]==mat[tl[1][0]][tl[1][1]]:
        x = int(mat[tl[0][0]][tl[0][1]])^1
        x = str(x)
        if mat[tr[0][0]][tr[0][1]]!=x:
            ans.append([n,n-1])
        if mat[tr[1][0]][tr[1][1]]!=x:
            ans.append([n-1,n])
    elif mat[tr[0][0]][tr[0][1]]==mat[tr[1][0]][tr[1][1]]:
        x = int(mat[tr[0][0]][tr[0][1]])^1
        x = str(x)
        if mat[tl[0][0]][tl[0][1]]!=x:
            ans.append([1,2])
        if mat[tl[1][0]][tl[1][1]]!=x:
            ans.append([2,1])
    else:
        if mat[0][1]=='1':
            ans.append([1,2])
        if mat[1][0]=='1':
            ans.append([2,1])
        if mat[-1][-2]=='0':
            ans.append([n,n-1])
        if mat[-2][-1]=='0':
            ans.append([n-1,n])
    print(len(ans))
    for i in ans:
        print(*i)