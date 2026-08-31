mas=[]
for i in range(4):
    q = input()
    mas.append([])
    for j,x in enumerate(q):
        mas[i].append(x)
from sys import exit
for i in range(4):
    for j in range(1,3):
        a,b,c=mas[i][j],mas[i][j-1],mas[i][j+1]
        if a=='.' and b=='x' and c=='x':
            print('YES')
            exit()
        if a=='x' and b=='.' and c=='x':
            print('YES')
            exit()
        if a=='x' and b=='x' and c=='.':
            print('YES')
            exit()
for i in range(1,3):
    for j in range(4):
        a,b,c=mas[i][j],mas[i-1][j],mas[i+1][j]
        if a=='.' and b=='x' and c=='x':
            print('YES')
            exit()
        if a=='x' and b=='.' and c=='x':
            print('YES')
            exit()
        if a=='x' and b=='x' and c=='.':
            print('YES')
            exit()
for i in range(1,3):
    for j in range(1,3):
        a,b,c=mas[i][j],mas[i-1][j+1],mas[i+1][j-1]
        if a=='.' and b=='x' and c=='x':
            print('YES')
            exit()
        if a=='x' and b=='.' and c=='x':
            print('YES')
            exit()
        if a=='x' and b=='x' and c=='.':
            print('YES')
            exit()
        b,c=mas[i-1][j-1],mas[i+1][j+1]
        if a=='.' and b=='x' and c=='x':
            print('YES')
            exit()
        if a=='x' and b=='.' and c=='x':
            print('YES')
            exit()
        if a=='x' and b=='x' and c=='.':
            print('YES')
            exit()
print('NO')
