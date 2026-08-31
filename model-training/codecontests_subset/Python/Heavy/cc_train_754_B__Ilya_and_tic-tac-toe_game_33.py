x=[]
for i in range(4):
    x.append(list(input()))

def check(a,b):
    x[a][b]='x'
    for i in range(4):
        for j in range(2):
            if x[i][j]+x[i][j+1]+x[i][j+2]=='xxx':
                return('YES')
    for i in range(2):
        for j in range(4):
            if x[i][j]+x[i+1][j]+x[i+2][j]=='xxx':
                return('YES')
    if x[2][0]+x[1][1]+x[0][2]=='xxx':return('YES')
    if x[3][0]+x[2][1]+x[1][2]=='xxx':return('YES')
    if x[2][1]+x[1][2]+x[0][3]=='xxx':return('YES')
    if x[3][1]+x[2][2]+x[1][3]=='xxx':return('YES')
    if x[0][0]+x[1][1]+x[2][2]=='xxx':return('YES')
    if x[1][0]+x[2][1]+x[3][2]=='xxx':return('YES')
    if x[0][1]+x[1][2]+x[2][3]=='xxx':return('YES')
    if x[1][1]+x[2][2]+x[3][3]=='xxx':return('YES')
    return('NO')

for i in range(4):
    for j in range(4):
        if x[i][j]=='.':
            if check(i,j)=='YES':
                print('YES')
                quit()
            x[i][j]='.'

else:
    print('NO')
