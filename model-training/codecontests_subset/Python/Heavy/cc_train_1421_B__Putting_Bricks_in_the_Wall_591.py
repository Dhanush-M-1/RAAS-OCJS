tc = int(input())
for _ in range(tc):
    n = int(input())
    mat = []
    for i in range(n):
        x = input()
        mat.append([j for j in x])
    count = []
    if mat[1][0] == mat[0][1]:
        if mat[n-1][n-2] == mat[n-2][n-1]:
            if mat[1][0] == mat[n-1][n-2]:
                count.append([1,2])
                count.append([2,1])
        else:
            if mat[n-1][n-2] == mat[1][0]:
                count.append([n,n-1])
            else:
                count.append([n-1,n])
    else:
        if mat[n-1][n-2] == mat[n-2][n-1]:
            if mat[0][1] == mat[n-1][n-2]:
                count.append([1,2])
            else:
                count.append([2,1])
        else:
            if mat[n-1][n-2] == mat[1][0]:
                count.append([1,2])
                count.append([n,n-1])
            else:
                count.append([1,2])
                count.append([n-1,n])
    print(len(count))
    for i in count:
        print(i[0],i[1])