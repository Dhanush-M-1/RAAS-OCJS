# Problem Link: http://codeforces.com/problemset/problem/143/A
# Author: Raunak Sett
import sys
reader = (s.rstrip() for s in sys.stdin)
input = reader.__next__

# do magic here
r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

used = [False for i in range(9)]
board = [0, 0, 0, 0]

def isSafe(board):
    row1 = board[0] + board[1] <= r1
    row2 = board[2] + board[3] <= r2
    col1 = board[0] + board[2] <= c1
    col2 = board[1] + board[3] <= c2
    diag1 = board[0] + board[3] <= d1
    diag2 = board[2] + board[1] <= d2
    return row1 and row2 and col1 and col2 and diag1 and diag2

def isSolved(board):
    row1 = board[0] + board[1] == r1
    row2 = board[2] + board[3] == r2
    col1 = board[0] + board[2] == c1
    col2 = board[1] + board[3] == c2
    diag1 = board[0] + board[3] == d1
    diag2 = board[2] + board[1] == d2
    return row1 and row2 and col1 and col2 and diag1 and diag2

def solve(board, itr):
    if itr == 4:
        return isSolved(board)
    for i in range(1, 10):
        if not used[i-1] and isSafe(board):
            used[i-1] = True
            board[itr] = i
            if (solve(board, itr + 1)):
                return True
            used[i-1] = False
            board[itr] = 0
    return False

result = solve(board, 0)

if (result):
    print(str(board[0]) + " " + str(board[1]))
    print(str(board[2]) + " " + str(board[3]))
else:
    print("-1")
