import sys
d = []
for i in range(4):
    d.append(input())
for i in range(4):
    for j in range(4):
        if d[i][j] == 'x':
            if j+1 < 4 and j+1 >= 0 and i-1 >= 0 and i-1 < 4 and d[i-1][j+1] == 'x':
                if j+2 >= 0 and j+2 < 4 and i-2 >= 0 and i-2 < 4 and d[i-2][j+2] == '.':
                    print('YES')
                    sys.exit()
            if j+1 < 4 and j+1 >= 0 and i-1 >= 0 and i-1 < 4 and d[i-1][j+1] == '.':
                if j+2 >= 0 and j+2 < 4 and i-2 >= 0 and i-2 < 4 and d[i-2][j+2] == 'x':
                    print('YES')
                    sys.exit()
            if j+1 < 4 and j+1 >= 0 and i >= 0 and i < 4 and d[i][j+1] == 'x':
                    if j+2 >= 0 and j+2 < 4 and i >= 0 and i < 4 and d[i][j+2] == '.':
                        print('YES')
                        sys.exit()
            if j+1 < 4 and j+1 >= 0 and i >= 0 and i < 4 and d[i][j+1] == '.':
                    if j+2 >= 0 and j+2 < 4 and i >= 0 and i < 4 and d[i][j+2] == 'x':
                        print('YES')
                        sys.exit()
            if j+1 < 4 and j+1 >= 0 and i+1 >= 0 and i+1 < 4 and d[i+1][j+1] == 'x':
                    if j+2 >= 0 and j+2 < 4 and i+2 >= 0 and i+2 < 4 and d[i+2][j+2] == '.':
                        print('YES')
                        sys.exit()
            if j < 4 and j >= 0 and i+1 >= 0 and i+1 < 4 and d[i+1][j] == 'x':
                    if j >= 0 and j < 4 and i+2 >= 0 and i+2 < 4 and d[i+2][j] == '.':
                        print('YES')
                        sys.exit()
            if j < 4 and j >= 0 and i+1 >= 0 and i+1 < 4 and d[i+1][j] == '.':
                    if j >= 0 and j < 4 and i+2 >= 0 and i+2 < 4 and d[i+2][j] == 'x':
                        print('YES')
                        sys.exit()
            if j < 4 and j >= 0 and i-1 >= 0 and i-1 < 4 and d[i-1][j] == 'x':
                    if j >= 0 and j < 4 and i-2 >= 0 and i-2 < 4 and d[i-2][j] == '.':
                        print('YES')
                        sys.exit()
            if j < 4 and j >= 0 and i-1 >= 0 and i-1 < 4 and d[i-1][j] == '.':
                    if j >= 0 and j < 4 and i-2 >= 0 and i-2 < 4 and d[i-2][j] == 'x':
                        print('YES')
                        sys.exit()
            if j-1 < 4 and j-1 >= 0 and i-1 >= 0 and i-1 < 4 and d[i-1][j-1] == 'x':
                    if j-2 >= 0 and j-2 < 4 and i-2 >= 0 and i-2 < 4 and d[i-2][j-2] == '.':
                        print('YES')
                        sys.exit()
            if j-1 < 4 and j-1 >= 0 and i-1 >= 0 and i-1 < 4 and d[i-1][j-1] == '.':
                    if j-2 >= 0 and j-2 < 4 and i-2 >= 0 and i-2 < 4 and d[i-2][j-2] == 'x':
                        print('YES')
                        sys.exit()
            if j-1 < 4 and j-1 >= 0 and i >= 0 and i < 4 and d[i][j-1] == 'x':
                    if j-2 >= 0 and j-2 < 4 and i >= 0 and i < 4 and d[i][j-2] == '.':
                        print('YES')
                        sys.exit()
            if j-1 < 4 and j-1 >= 0 and i >= 0 and i < 4 and d[i][j-1] == '.':
                    if j-2 >= 0 and j-2 < 4 and i >= 0 and i < 4 and d[i][j-2] == 'x':
                        print('YES')
                        sys.exit()
            if j-1 < 4 and j-1 >= 0 and i+1 >= 0 and i+1 < 4 and d[i+1][j-1] == 'x':
                    if j-2 >= 0 and j-2 < 4 and i+2 >= 0 and i+2 < 4 and d[i+2][j-2] == '.':
                        print('YES')
                        sys.exit()
            if j-1 < 4 and j-1 >= 0 and i+1 >= 0 and i+1 < 4 and d[i+1][j-1] == '.':
                    if j-2 >= 0 and j-2 < 4 and i+2 >= 0 and i+2 < 4 and d[i+2][j-2] == 'x':
                        print('YES')
                        sys.exit()
print('NO')