from sys import stdin

for _ in range(int(stdin.readline())):
    side = int(stdin.readline())
    board = []
    for i in range(side):
        board.append(stdin.readline().strip())
    a = board[0][1]
    b = board[1][0]
    c = board[side-2][side-1]
    d = board[side-1][side-2]
    if a == b:
        if a == "1":
            if c == d:
                if c == "1":
                    print(2)
                    print(2,1)
                    print(1,2)
                else:
                    print(0)
            else:
                if c == "1":
                    print(1)
                    print(side-1, side)
                else:
                    print(1)
                    print(side, side-1)
        else:
            if c == d:
                if c == "1":
                    print(0)
                else:
                    print(2)
                    print(2,1)
                    print(1,2)
            else:
                if c == "1":
                    print(1)
                    print(side, side-1)
                else:
                    print(1)
                    print(side-1, side)
    else:
        if a == "1":
            if d == c:
                if d == "1":
                    print(1)
                    print(1, 2)
                else:
                    print(1)
                    print(2, 1)
            else:
                if d == "1":
                    print(2)
                    print(1,2)
                    print(side-1, side)
                else:
                    print(2)
                    print(1,2)
                    print(side, side-1)
        else:
            if d == c:
                if d == "1":
                    print(1)
                    print(2, 1)
                else:
                    print(1)
                    print(1, 2)
            else:
                if d == "1":
                    print(2)
                    print(2,1)
                    print(side-1, side)
                else:
                    print(2)
                    print(2,1)
                    print(side, side-1)
            