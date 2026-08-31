for _ in range(int(input())):
    n = int(input())
    ans = []
    mat = [input() for k in range(n)]
    if(mat[0][1] == '0' and mat[1][0] == '0'):
        if(mat[-1][-2] == '0'): ans.append([n, n-1])
        if(mat[-2][-1] == '0'): ans.append([n-1, n])
    elif (mat[0][1] == '1' and mat[1][0] == '1'):
        if(mat[-1][-2] == '1'): ans.append([n, n-1])
        if(mat[-2][-1] == '1'): ans.append([n-1, n])
    else:
        if(mat[-1][-2] == '1' and mat[-2][-1] == '1'):
            if(mat[0][1] == '1'): ans.append([1, 2])
            if(mat[1][0] == '1'): ans.append([2, 1])
        elif(mat[-1][-2] == '0' and mat[-2][-1] == '0'):
            if(mat[0][1] == '0'): ans.append([1, 2])
            if(mat[1][0] == '0'): ans.append([2, 1])
        else:
            if(mat[-1][-2] == '0'): ans.append([n, n-1])
            if(mat[-2][-1] == '0'): ans.append([n-1, n])
            if(mat[0][1] == '1'): ans.append([1, 2])
            if(mat[1][0] == '1'): ans.append([2, 1])
    print(len(ans))
    for e in ans:
        print(e[0], e[1])