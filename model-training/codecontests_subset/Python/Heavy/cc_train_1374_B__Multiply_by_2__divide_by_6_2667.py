import sys

def getR(numb):
    moves = 0
    n = numb

    while True:
        if 1 == n:
            return moves
        if n < 3:
            return -1
        
        if 0 == n % 6:
            n = n / 6
            moves += 1
        else:
            if 0 == n % 3:
                n = n / 3
                moves += 2
            else:
                return -1

data = sys.stdin.readlines()
data.pop(0)
for line in data:
    if not "" == line.rstrip():
        print(getR(int(line.rstrip())))