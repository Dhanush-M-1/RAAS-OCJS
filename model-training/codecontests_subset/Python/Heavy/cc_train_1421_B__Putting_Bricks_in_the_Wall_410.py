t = int(input())
while t > 0:
    n = int(input())
    mat = [input() for i in range(n)]
    ans = []
    if mat[0][1] == mat[1][0]:
        if mat[n-1][n-2] == mat[0][1]:
            ans.append([n-1, n-2])
        if mat[n-2][n-1] == mat[0][1]:
            ans.append([n-2, n-1])
    elif mat[n-1][n-2] == mat[n-2][n-1]:
        if mat[0][1] == mat[n-1][n-2]:
            ans.append([0, 1])
        if mat[1][0] == mat[n-1][n-2]:
            ans.append([1, 0])
    else:
        ans.append([1, 0])
        if mat[n-1][n-2] == mat[0][1]:
            ans.append([n-1, n-2])
        if mat[n-2][n-1] == mat[0][1]:
            ans.append([n-2, n-1])
    print(len(ans))
    for x, y in ans:
        print(x+1, y+1)
    t -= 1
