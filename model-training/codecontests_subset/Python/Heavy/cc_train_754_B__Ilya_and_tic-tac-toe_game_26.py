a = []
for _ in range(4):
    a.append(input())
res = 'NO'
for i, value in enumerate(a):
    if 'x.x' in value or 'xx.' in value or '.xx' in value:
        res = 'YES'
        break
    for j, vj in enumerate(value):
        if a[i][j] == 'x' and i > 1:
            if (a[i - 1][j] == '.' and a[i - 2][j] == 'x') or (a[i - 1][j] == 'x' and a[i - 2][j] == '.'):
                res = 'YES'
                break

            if j > 1 and ((a[i - 1][j - 1] == '.' and a[i - 2][j - 2] == 'x') or (
                    a[i - 1][j - 1] == 'x' and a[i - 2][j - 2] == '.')):
                res = 'YES'
                break

            if j < 2 and ((a[i - 1][j + 1] == '.' and a[i - 2][j + 2] == 'x') or (
                    a[i - 1][j + 1] == 'x' and a[i - 2][j + 2] == '.')):
                res = 'YES'
                break
        if a[i][j] == '.' and i > 1:
            if a[i - 1][j] == 'x' and a[i - 2][j] == 'x':
                res = 'YES'
                break

            if j > 1 and (a[i - 1][j - 1] == 'x' and a[i - 2][j - 2] == 'x'):
                res = 'YES'
                break

            if j < 2 and (a[i - 1][j + 1] == 'x' and a[i - 2][j + 2] == 'x'):
                res = 'YES'
                break
    if res == 'YES':
        break
print(res)