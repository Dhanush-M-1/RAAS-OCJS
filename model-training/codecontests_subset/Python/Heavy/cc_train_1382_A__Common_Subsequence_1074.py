import io
import os

from collections import Counter, defaultdict, deque


def solve(N, M, A, B):
    both = set(A) & set(B)
    if not both:
        return "NO"
    ans = next(iter(both))
    return "YES\n1 " + str(ans)


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    T = int(input())
    for t in range(T):
        N, M = [int(x) for x in input().split()]
        A = [int(x) for x in input().split()]
        B  = [int(x) for x in input().split()]
        ans = solve(N, M, A, B)
        print(ans)
