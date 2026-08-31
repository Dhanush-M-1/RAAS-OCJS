n = int(input())
i = 0
Col = []
Colnum =[]
Col2 = []
Col2num = []
while i < n:
    i += 1
    B = [int(x) for x in input().split()]
    if B[0] not in Col:
        Col.append(B[0])
        Colnum.append(1)
    else:
        c = Col.index(B[0])
        Colnum[c] += 1
    if B[1] not in Col2:
        Col2.append(B[1])
        Col2num.append(1)
    else:
        c = Col2.index(B[1])
        Col2num[c] += 1

T = 0


for i in range(len(Col2)):
    if Col2[i] in Col:
        m = Col.index(Col2[i])
        T +=  Col2num[i]*Colnum[m]

print(T)

