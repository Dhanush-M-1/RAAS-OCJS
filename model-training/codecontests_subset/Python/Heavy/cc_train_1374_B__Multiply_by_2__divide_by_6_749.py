from collections import defaultdict as dd
from collections import deque
import bisect
import heapq

def ri():
    return int(input())

def rl():
    return list(map(int, input().split()))


def solve():
    n = ri()
    moves = 0
    while 1:
        if n == 1:
            break
        elif n % 3 != 0:
            print (-1)
            return
        elif n % 6 == 0:
            n //= 6
            moves += 1
        else:
            n //= 3
            moves += 2

    print (moves)





mode = 'T'

if mode == 'T':
    t = ri()
    for i in range(t):
        solve()
else:
    solve()
