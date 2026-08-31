import io
import os

from collections import Counter, defaultdict, deque


def solve(N, A):
    a = A[0]
    b = A[1]
    c = A[-1]
    if a + b > c and a + c > b and b + c > a:
        return -1
    return str(1) + ' ' + str(2) + ' ' + str(N)


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    TC = int(input())
    for tc in range(1, TC + 1):
        N, = [int(x) for x in input().split()]
        A = [int(x) for x in input().split()]
        ans = solve(N, A)
        print(ans)

