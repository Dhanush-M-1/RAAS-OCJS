def f(i, j):
    b = [a[i][:] for i in range(4)]
    if b[i][j] != '.': return 0
    b[i][j] = 'x'
    #print('\n'.join(map(str, b)))
    for i in range(4):
        for j in range(4):
            f1 = f2 = f3 = f4 = 1
            for k in range(3):
                if i + k >= 4 or j + k >= 4: f3 = 0
                elif b[i + k][j + k] != 'x': f3 = 0
                if i + k >= 4: f1 = 0
                elif b[i + k][j] != 'x': f1 = 0
                if j + k >= 4: f2 = 0
                elif b[i][j + k] != 'x': f2 = 0
                if i + k >= 4 or j - k < 0: f4 = 0
                elif b[i + k][j - k] != 'x': f4 = 0
            if f1 or f2 or f3 or f4: return 1
    return 0

a = [list(input()) for i in range(4)]
for i in range(4):
    for j in range(4):
        if f(i, j):
            print('YES')
            exit()
print('NO')