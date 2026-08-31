def solve(A):
    for i in range(4):
        for j in range(4):
            if A[i][j] == '.':
                for x, y in ((-1, 0), (-1, 1), (0, 1), (1, 1)):
                    if -1<i+x<4 and -1<i-x<4 and -1<j+y<4 and -1<j-y<4:
                        if A[i+x][j+y] == 'x' and A[i-x][j-y] == 'x':
                            return True
            if A[i][j] == 'x':
                for x, y in ((-1, 0), (-1, 1), (0, 1), (1, 1)):
                    if -1<i+x<4 and -1<i-x<4 and -1<j+y<4 and -1<j-y<4:
                        if A[i+x][j+y] == 'x' and A[i-x][j-y] == '.':
                            return True
                        if A[i+x][j+y] == '.' and A[i-x][j-y] == 'x':
                            return True
    return False

A = [input().rstrip() for i in range(4)]
print('YES' if solve(A) else 'NO')
