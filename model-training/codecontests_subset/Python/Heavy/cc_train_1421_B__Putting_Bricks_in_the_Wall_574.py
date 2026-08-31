for _ in range(int(input())):
    n = int(input())
    mat = []
    for i in range(n):
        mat.append(list(input()))
    # a = 0
    ans = []
    if mat[0][1] == mat[1][0]:
        v = int(mat[0][1])
        if int(mat[n - 1][n - 2]) != abs(v - 1):
            ans.append([n, n - 1])
        if int(mat[n - 2][n - 1]) != abs(v - 1):
            ans.append([n - 1, n])
    elif int(mat[n - 2][n - 1]) == int(mat[n - 1][n - 2]):
        v = int(mat[n - 2][n - 1])
        if int(mat[0][1]) != abs(v - 1):
            ans.append([1, 2])
        if int(mat[1][0]) != abs(v - 1):
            ans.append([2, 1])
    else:
        if mat[0][1] == '1':
            ans.append([1, 2])
        else:
            ans.append([2, 1])

        if mat[n - 1][n - 2] == '0':
            ans.append([n, n - 1])
        else:
            ans.append([n - 1, n])

    print(len(ans))
    for i in ans:
        print(i[0], i[1])

