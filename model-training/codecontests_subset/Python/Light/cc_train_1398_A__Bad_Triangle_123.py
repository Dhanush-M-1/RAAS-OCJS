
import collections
from functools import lru_cache


def read():
    return input().strip()


def readInt():
    return int(input().strip())


def readList():
    return list(map(int, input().strip().split()))


def solve(N, arr):
    a, b, c = arr[0], arr[1], arr[-1]

    if a+b <= c:
        return " ".join(map(str, [1, 2, N]))
    else:
        return "-1"


t = readInt()

for i in range(t):
    N = readInt()
    arr = readList()

    print(solve(N, arr))
