t = int(input())

nLst = []
triLst = []

for tt in range(t):
    n_i = int(input())
    nLst.append(n_i)
    tri = input().split()
    for x in range(len(tri)):
        tri[x] = int(tri[x])
    triLst.append(tri)

for i in range(t):
    for j in range(2, len(triLst[i])):
        if (triLst[i][0] + triLst[i][1] <= triLst[i][j]):
            print('1 2', j+1)
            break
        elif j == len(triLst[i]) - 1:
            print(-1)
            break
        else:
            continue
