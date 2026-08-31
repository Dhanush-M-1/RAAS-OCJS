##n = int(input())
##a = list(map(int, input().split()))
##print(' '.join(map(str, res)))

def check(a):
    for i in range(4):
        for j in range(4):
            if a[i][j] == 'x':
                if i+2 < 4 and a[i+1][j] == 'x' and a[i+2][j] == 'x':
                    return True
                if j+2 < 4 and a[i][j+1] == 'x' and a[i][j+2] == 'x':
                    return True
                if i+2 < 4 and j+2 < 4 and a[i+1][j+1] == 'x' and a[i+2][j+2] == 'x':
                    return True
                if i+2 < 4 and j-2 >= 0 and a[i+1][j-1] == 'x' and a[i+2][j-2] == 'x':
                    return True
    return False

a = []
for i in range(4):
    a.append(list(input()))

for i in range(4):
    for j in range(4):
        if a[i][j] == '.':
            a[i][j] = 'x'
            if check(a) == True:
                print('YES')
                exit(0)
            a[i][j] = '.'
print('NO')

