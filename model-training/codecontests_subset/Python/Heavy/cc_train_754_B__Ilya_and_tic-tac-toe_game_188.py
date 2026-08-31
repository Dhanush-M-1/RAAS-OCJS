m=[]
for i in range(4):
    m.append(input())
for i in range(4):
    s=''
    for j in range(4):
        s+=m[j][i]
    m.append(s)
for x in range(2):
    for y in range(2):
        s=''
        for i in range(3):
            s+=m[i+x][i+y]
        m.append(s)
for x in range(2):
    for y in range(2):
        s=''
        for i in range(3):
            s+=m[3-i-x][i+y]
        m.append(s)
for i in m:
    if 'x.x' in i or 'xx.' in i or '.xx' in i:
        print('YES')
        break
else:
    print('NO')