arr = ['xx.', 'x.x', '.xx']
s = [input() for i in range(4)]
res = 'NO'
for i in range(4):
    a = s[i][0] + s[i][1] + s[i][2]
    b = s[i][1] + s[i][2] + s[i][3]
    if (a in arr) or (b in arr):
        res = 'YES'
for j in range(4):
    a = s[0][j] + s[1][j] + s[2][j]
    b = s[1][j] + s[2][j] + s[3][j]
    if  (a in arr) or (b in arr):
        res = 'YES'
for i in range(1, 3):
    for j in range(1, 3):
        a = s[i-1][j-1] + s[i][j] + s[i+1][j+1]
        b = s[i-1][j+1] + s[i][j] + s[i+1][j-1]
        if (a in arr) or (b in arr):
            res = 'YES'
print(res)
