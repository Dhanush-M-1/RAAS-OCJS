t = int(input())
for k in range(t):
    a = int(input())
    flag = True
    vet = []
    for r in range(a):
        x, y = list(map(int,input().split()))
        vet.append([x,y])

    if vet[0][1] > vet[0][0]:
        flag = False

    for i in range(1,len(vet)):
        pA = vet[i][0]
        pAA = vet[i-1][0]
        cA = vet[i][1]
        cAA = vet[i-1][1]
        if pA < pAA:
            flag = False
            break
        if cA < cAA:
            flag = False
            break
        if pA-pAA < cA-cAA:
            flag = False
            break
        if cA > pA:
            flag = False
            break

    if flag:
        print("YES")
    else:
        print("NO")













