import io
import os

from collections import Counter, defaultdict, deque


def solve(N, A):
    m = N // 2
    if N % 2 == 0:
        best1 = list(range(m + 1)) + list(range(m - 1))[::-1]
        best2 = best1[::-1]
        bests = [best1, best2]
    else:
        best = list(range(m + 1)) + list(range(m))[::-1]
        bests = [best]
    for best in bests:
        assert len(best) == len(A)

        if all(x >= y for x, y in zip(A, best)):
            return "Yes"
    return "No"


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    T = int(input())
    for t in range(T):
        (N,) = [int(x) for x in input().split()]
        A = [int(x) for x in input().split()]
        ans = solve(N, A)
        print(ans)
