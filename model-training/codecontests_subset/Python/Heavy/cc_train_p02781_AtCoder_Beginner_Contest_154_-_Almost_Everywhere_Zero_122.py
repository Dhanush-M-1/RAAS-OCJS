import sys
from functools import lru_cache

input = sys.stdin.readline

sys.setrecursionlimit(10 ** 8)


@lru_cache(maxsize=None)
def solve(n, k):
    if n < 10:
        if k == 1:
            return n
        elif k == 0:
            return 1
        else:
            return 0

    q, r = divmod(n, 10)

    return solve(q, k) + solve(q, k - 1) * r + solve(q - 1, k - 1) * (9 - r)


def main():
    N = int(input())
    K = int(input())

    print(solve(N, K))


if __name__ == '__main__':
    main()
