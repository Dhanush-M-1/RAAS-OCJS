p = [input() for _ in range(4)]


won = False

target = ['.xx', 'x.x', 'xx.']

for z in p:
    for t in target:
        if t in z:
            won = True
            break

for i in range(2):
    for j in range(2):
        s = ''
        t = ''
        for k in range(3):
            s += p[i + k][j + k]
            t += p[i + k][3 - (j + k)]
        if s in target:
            won = True
            break
        if t in target:
            won = True
            break

for i in range(4):
    s = ''
    for j in range(4):
        s += p[j][i]
    for t in target:
        if t in s:
            won = True
            break
        
print('YES' if won else 'NO')