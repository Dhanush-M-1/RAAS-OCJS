# 754B
import sys

board = []
while True:
    w = sys.stdin.readline().strip()
    if not w:
        break
    for i in range(0,2):
        if (w[i] == '.' and w[i + 1] == 'x' and w[i + 2] == 'x') \
        or (w[i] == 'x' and w[i + 1] == 'x' and w[i + 2] == '.') \
        or (w[i] == 'x' and w[i + 1] == '.' and w[i + 2] == 'x'):
            print('YES')
            exit()
    board.append(w)

for i in range(0,2):
    for j in range(0,4):
        if (board[i][j] == '.' and board[i + 1][j] == 'x' and board[i + 2][j] == 'x') \
        or (board[i][j] == 'x' and board[i + 1][j] == 'x' and board[i + 2][j] == '.') \
        or (board[i][j] == 'x' and board[i + 1][j] == '.' and board[i + 2][j] == 'x'):
            print('YES')
            exit()
for i in range(0,2):
    for j in range(0,2):
        if (board[i][j] == '.' and board[i + 1][j + 1] == 'x' and board[i + 2][j + 2] == 'x') \
        or (board[i][j] == 'x' and board[i + 1][j + 1] == 'x' and board[i + 2][j + 2] == '.') \
        or (board[i][j] == 'x' and board[i + 1][j + 1] == '.' and board[i + 2][j + 2] == 'x'):
            print('YES')
            exit()
for i in range(0,2):
    for j in range(2,4):
        if (board[i][j] == '.' and board[i + 1][j - 1] == 'x' and board[i + 2][j - 2] == 'x') \
        or (board[i][j] == 'x' and board[i + 1][j - 1] == 'x' and board[i + 2][j - 2] == '.') \
        or (board[i][j] == 'x' and board[i + 1][j - 1] == '.' and board[i + 2][j - 2] == 'x'):
            print('YES')
            exit()

print('NO')
