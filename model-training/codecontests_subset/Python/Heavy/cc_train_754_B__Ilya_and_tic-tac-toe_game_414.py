# Problem B

import sys

def winlose(board):
    # 行にxxxが並んでるか調べる
    for i in range(4):
        if "xxx" in "".join(board[i]):
            return True

    t_board = list(map(list, zip(*board))) # 行と列を入れ替えたボードを作る

    # 列にxxxが並んでいるか調べる
    for i in range(4):
        if "xxx" in "".join(t_board[i]):
            return True

    # 斜めの探索
    d1 = board[0][0] + board[1][1] + board[2][2]
    d2 = board[1][1] + board[2][2] + board[3][3]
    d3 = board[0][1] + board[1][2] + board[2][3]
    d4 = board[1][0] + board[2][1] + board[3][2]
    d5 = board[0][3] + board[1][2] + board[2][1]
    d6 = board[1][2] + board[2][1] + board[3][0]
    d7 = board[0][2] + board[1][1] + board[2][0]
    d8 = board[1][3] + board[2][2] + board[3][1]

    if "xxx" in {d1, d2, d3, d4, d5, d6, d7, d8}:
        return True
    else:
        return False

board = []

for _ in range(4):
    board.append(list((input())))

for i in range(4):
    for j in range(4):
        if board[i][j] == ".": # 全探索
            board[i][j] = "x"
            if winlose(board) == True:
                print("YES")
                sys.exit(0)
            board[i][j] = "."

print("NO")