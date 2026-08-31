PAT = ['xx.', 'x.x', '.xx']
s = [input() for i in range(4)]
res = 'NO'

for i in range(4):
    if (s[i][0] + s[i][1] + s[i][2] in PAT) or (s[i][1] + s[i][2] + s[i][3] in PAT):
        res = 'YES'
for j in range(4):
    if (s[0][j] + s[1][j] + s[2][j] in PAT) or (s[1][j] + s[2][j] + s[3][j] in PAT):
        res = 'YES'
for i in range(1, 3):
    for j in range(1, 3):
        if (s[i-1][j-1] + s[i][j] + s[i+1][j+1] in PAT) or (s[i-1][j+1] + s[i][j] + s[i+1][j-1] in PAT):
            res = 'YES'

print(res)