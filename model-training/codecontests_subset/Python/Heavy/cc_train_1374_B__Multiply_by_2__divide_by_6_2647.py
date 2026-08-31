import io
import os

from collections import Counter, defaultdict, deque


def solve(N,):
    pow3 = 0
    while N % 3 == 0:
        pow3 += 1
        N //= 3

    pow2 = 0
    while N % 2 == 0:
        pow2 += 1
        N //= 2
    if N != 1 or pow3 < pow2:
        return -1

    return (pow3 - pow2) + pow3


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    T = int(input())
    for t in range(T):
        (N,) = [int(x) for x in input().split()]
        ans = solve(N,)
        print(ans)
