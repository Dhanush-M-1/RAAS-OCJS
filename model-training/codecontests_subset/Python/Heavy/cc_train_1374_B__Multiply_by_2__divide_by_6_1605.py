import sys
input = sys.stdin.readline

# Input Functions

# Take integer input
def inp():
    return(int(input()))
# Take list input
def inlt():
    return(list(map(int, input().split())))
# Take string as list of characters
def insr():
    s = input()
    return(s[:len(s) - 1])
# Take space separated integer variable inputs
def invr():
    return(map(int, input().split()))

T = inp()

tests = []

for _ in range(T):
    tests.append(inp())

for n in tests:
    moves = 0
    while n > 1:
        if n % 6 == 0:
            n //= 6
            moves += 1
        else:
            n *= 2
            if n % 6 != 0:
                moves = -1
                break
            else:
                moves += 1
    print(moves)
