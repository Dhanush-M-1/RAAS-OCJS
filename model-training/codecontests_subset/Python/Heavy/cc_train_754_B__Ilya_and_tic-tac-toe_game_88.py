L = []
for i in range(0,4):
    L.append(input())

horizontal = True
vertical = True
diagonal = True

O = []
for i in L:
    O.append(i[:-1])
    O.append(i[1:])

for i in range(0,4):
    for j in range(0,2):
        w = L[j][i]+L[j+1][i]+L[j+2][i]
        O.append(w)


for i in range(0,2):
    for j in range(0,2):
        w = L[j][i]+L[j+1][i+1]+L[j+2][i+2]
        O.append(w)

for i in range(2,4):
    for j in range(0,2):
        w = L[j][i]+L[j+1][i-1]+L[j+2][i-2]
        O.append(w)

c = False
V = ['x.x','xx.','.xx']
for i in V:
    if i in O:
        c = True

if c:
    print('YES')
else:
    print('NO')