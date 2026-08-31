board = []
for i in range(4):
    board.append(input())

def isX(i, j):
    if 0 <= i < 4 and 0 <= j < 4:
        return board[i][j] == 'x'
    return False


def win(i, j):
    if isX(i-1, j-1) and (isX(i-2,j-2) or isX(i+1,j+1)):
        return True
    if isX(i-1, j) and (isX(i-2,j) or isX(i+1,j)):
        return True
    if isX(i-1,j+1) and (isX(i-2,j+2) or isX(i+1,j-1)):
        return True
    if isX(i,j-1) and (isX(i,j-2) or isX(i,j+1)):
        return True
    if isX(i,j+1) and isX(i,j+2):
        return True
    if isX(i+1,j-1) and isX(i+2,j-2):
        return True
    if isX(i+1,j) and isX(i+2, j):
        return True
    if isX(i+1,j+1) and isX(i+2,j+2):
        return True
    return False


for i in range(4):
    for j in range(4):
        if board[i][j] == '.' and win(i, j):
            print('YES')
            break
    else:
        continue
    break
else:
    print('NO')
