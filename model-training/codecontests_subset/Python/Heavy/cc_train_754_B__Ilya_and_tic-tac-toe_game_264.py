def v_mid(a, i, j):
    return a[i - 1][j] == a[i][j] == a[i + 1][j] == 'x'

def h_mid(a, i, j):
    return a[i][j - 1] == a[i][j] == a[i][j + 1] == 'x'

def upper(a, i, j):
    return a[i - 2][j] == a[i - 1][j] == a[i][j] == 'x'

def lower(a, i, j):
    return a[i + 2][j] == a[i + 1][j] == a[i][j] == 'x'

def left(a, i, j):
    return a[i][j - 2] == a[i][j - 1] == a[i][j] == 'x'

def right(a, i, j):
    return a[i][j + 2] == a[i][j + 1] == a[i][j] == 'x'

def l_diag(a, i, j):
    return a[i + 1][j - 1] == a[i][j] == a[i - 1][j + 1] == 'x'

def r_diag(a, i, j):
    return a[i + 1][j + 1] == a[i][j] == a[i - 1][j - 1] == 'x'

def u_l_diag(a, i, j):
    return a[i - 2][j - 2] == a[i - 1][j - 1] == a[i][j] == 'x'

def u_r_diag(a, i, j):
    return a[i - 2][j + 2] == a[i - 1][j + 1] == a[i][j] == 'x'

def d_r_diag(a, i, j):
    return a[i + 2][j + 2] == a[i + 1][j + 1] == a[i][j] == 'x'

def d_l_diag(a, i, j):
    return a[i + 2][j - 2] == a[i + 1][j - 1] == a[i][j] == 'x'

a = []
a.append(['.'] * 8)
a.append(['.'] * 8)
for i in range(4):
    s = list(input())
    t = ['.', '.'] + s + ['.', '.']
    a.append(t)
a.append(['.'] * 8)
a.append(['.'] * 8)
for i in range(2, 6):
    for j in range(2, 6):
        if a[i][j] == '.':
            a[i][j] = 'x'
            if v_mid(a, i, j) or h_mid(a, i, j) or upper(a, i, j) or lower(a, i, j) or \
            left(a, i, j) or right(a, i, j) or l_diag(a, i, j) or r_diag(a, i, j) or \
            u_l_diag(a, i, j) or u_r_diag(a, i, j) or d_r_diag(a, i, j) or d_l_diag(a, i, j):
                print("YES")
                exit()
            a[i][j] = '.'
print("NO")