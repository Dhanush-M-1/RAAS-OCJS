def check(board):
    for i in range(4):
        for j in range(2):
            if board[i][j] == board[i][j+1] == board[i][j+2] == 'x':
                return True
    for i in range(2):
        for j in range(4):
            if board[i][j] == board[i+1][j] == board[i+2][j] == 'x':
                return True
    for i in range(2):
        for j in range(2):
            if board[i][j] == board[i+1][j+1] == board[i+2][j+2] == 'x':
                return True
    for i in range(2):
        for j in range(2, 4):
            if board[i][j] == board[i+1][j-1] == board[i+2][j-2] == 'x':
                return True
    return False

board = []
for _ in range(4):
    board.append(input())
# print(board)
# print(check(board))
possible = False
for i in range(4):
    for j in range(4):
        if board[i][j] == '.':
            board[i] = board[i][:j] + 'x' + board[i][j+1:]
            if check(board):
                possible = True
                # print(board)
            board[i] = board[i][:j] + '.' + board[i][j + 1:]
print('YES' if possible else 'NO')
