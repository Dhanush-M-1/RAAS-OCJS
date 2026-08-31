"""Problem A - Chess Placing.

http://codeforces.com/contest/985/problem/a

You are given a chessboard of size 1 × n. It is guaranteed that n is even. The
chessboard is painted like this: "BWBW...BW".

Some cells of the board are occupied by the chess pieces. Each cell contains
no more than one chess piece. It is known that the total number of pieces
equals to .

In one step you can move one of the pieces one cell to the left or to the
right. You cannot move pieces beyond the borders of the board. You also cannot
move pieces to the cells that are already occupied.

Your task is to place all the pieces in the cells of the same color using the
minimum number of moves (all the pieces must occupy only the black cells or
only the white cells after all the moves are made).

Input:

The first line of the input contains one integer n (2 ≤ n ≤ 100, n is even) —
the size of the chessboard.

The second line of the input contains integer numbers (1 ≤ pi ≤ n) — initial
positions of the pieces. It is guaranteed that all the positions are distinct.

Output:

Print one integer — the minimum number of moves you have to make to place all
the pieces in the cells of the same color.

"""
import logging


fmt = '%(levelname)s - %(name)s (line:%(lineno)s) - %(message)s'
formatter = logging.Formatter(fmt)

ch = logging.StreamHandler()
ch.setLevel(logging.ERROR)
ch.setFormatter(formatter)

logger = logging.getLogger('chess_placing')
logger.setLevel(logging.ERROR)
logger.addHandler(ch)


def solve(pos):
    pos = sorted(pos)
    return min(
        sum(abs(2 * i + 1 - pos[i]) for i in range(len(pos))),
        sum(abs(2 * i + 2 - pos[i]) for i in range(len(pos)))
    )


def main():
    _ = input()
    positions = [int(x) for x in input().strip().split()]
    result = solve(positions)
    print(result)
    

if __name__ == '__main__':
    main()
