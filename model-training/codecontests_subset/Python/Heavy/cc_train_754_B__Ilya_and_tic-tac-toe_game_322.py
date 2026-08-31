board = [input() for i in range(4)]
def test(board, ps):
    empty = 0
    cross = 0
    for (i, j) in ps:
        if board[i][j] == 'x':
            cross += 1
        elif board[i][j] == '.':
            empty += 1
    return empty == 1 and cross == 2
check = [
    ([(i ,j) for j in range(3)] for i in range(4)),
    ([(i ,j) for j in range(1, 4)] for i in range(4)),
    ([(i, j) for i in range(3)] for j in range(4)),
    ([(i, j) for i in range(1, 4)] for j in range(4)),
    ([(i + k, j + k) for k in range(3)] for i in range(2) for j in range(2)),
    ([(i + k, j - k) for k in range(3)] for i in range(2) for j in range(2, 4))
]
for i in check:
    for j in i:
        if test(board, j):
            print('YES')
            break
    else:
        continue
    break
else:
    print('NO')
