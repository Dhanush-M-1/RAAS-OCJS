
v = ['xx.' , '.xx' , 'x.x']
g = []
for i in range(4):
    g.append(input())

res = 'NO'
#Rows
for i in range(4):
    if (g[i][0] + g[i][1] + g[i][2] in v) or (g[i][1] + g[i][2] + g[i][3] in v):
        res = 'YES'

#colums
for i in range(4):
    if (g[0][i] + g[1][i] + g[2][i] in v) or (g[1][i] + g[2][i] + g[3][i] in v):
        res = 'YES'

#diagonals
for i in range(1 , 3):
    for j in range(1 , 3):
        if (g[i - 1][j - 1] + g[i][j] + g[i + 1][j + 1] in v) or (g[i- 1][j+1] + g[i][j] + g[i+1][j-1] in v):
            res = 'YES'


print(res)




