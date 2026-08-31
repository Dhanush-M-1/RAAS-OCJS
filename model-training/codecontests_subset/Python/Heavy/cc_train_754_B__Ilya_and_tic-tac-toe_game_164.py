def check_win(board):
    for row in board:
        if row[0:3] == 'xxx':
            return True
        if row[1:4] == 'xxx':
            return True

    for col_num in range(len(board)):
        if board[0][col_num] == board[1][col_num] == board[2][col_num] == 'x':
            return True
        if board[1][col_num] == board[2][col_num] == board[3][col_num] == 'x':
            return True

    if board[0][0] == board[1][1] == board[2][2] == 'x':
        return True
    if board[0][1] == board[1][2] == board[2][3] == 'x':
        return True
    if board[1][0] == board[2][1] == board[3][2] == 'x':
        return True
    if board[1][1] == board[2][2] == board[3][3] == 'x':
        return True

    if board[3][0] == board[2][1] == board[1][2] == 'x':
        return True
    if board[3][1] == board[2][2] == board[1][3] == 'x':
        return True
    if board[2][0] == board[1][1] == board[0][2] == 'x':
        return True
    if board[2][1] == board[1][2] == board[0][3] == 'x':
        return True

    return False


def codeforces(board):
    for row_num in range(len(board)):
        for elem_num in range(len(board[row_num])):
            if board[row_num][elem_num] == '.':
                board[row_num] = board[row_num][:elem_num] + 'x' + \
                                    board[row_num][(elem_num+1):]
                if check_win(board):
                    return 'YES'
                board[row_num] = board[row_num][:elem_num] + '.' + \
                    board[row_num][(elem_num+1):]

    return 'NO'

board = []
for _ in range(4):
    row = input()
    board.append(row)

print(codeforces(board))
