import io
import os

from collections import Counter, defaultdict, deque
from bisect import bisect


def solve(N, M, S, P):
    P.sort()
    counts = Counter()
    for i, c in enumerate(S):
        index = bisect(P, i)
        counts[c] += M - index
        counts[c] += 1
    return " ".join([str(counts[chr(ord("a") + i)]) for i in range(26)])


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    T = int(input())
    for t in range(T):
        N, M = [int(x) for x in input().split()]
        S = str(input().decode().rstrip())
        P = [int(x) for x in input().split()]
        ans = solve(N, M, S, P)
        print(ans)
