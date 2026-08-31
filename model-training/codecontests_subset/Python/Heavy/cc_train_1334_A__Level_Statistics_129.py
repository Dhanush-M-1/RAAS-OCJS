t = int(input())

for x in range(t):
    n = int(input())
    listAux = []
    flag=True
    for j in range(n):
        p, c = list(map(int,input().split()))
        listAux.append([p,c])

    if listAux[0][0] < listAux[0][1]:
        flag=False
    else:
        for i in range(1, len(listAux)):
            if (listAux[i][0] == listAux[i-1][0] and listAux[i][1] != listAux[i-1][1]) or (listAux[i][0]-listAux[i-1][0] < listAux[i][1]-listAux[i-1][1]) or (listAux[i][0] < listAux[i-1][0]) or (listAux[i][1] < listAux[i-1][1]):
                flag = False
                break

    if flag == False:
        print('NO')
    else:
        print('YES')


