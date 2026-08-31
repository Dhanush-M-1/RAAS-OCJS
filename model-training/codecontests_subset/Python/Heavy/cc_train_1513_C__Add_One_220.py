"""
usefull snippets:
    - map(int, input().split())
    - map(int, sys.stdin.readline().split()))
    - int(input())
    - int(sys.stdin.readline().strip())

    - sys.stdout.write()
    - sys.stdout.write(" ".join(map(str, c) # writes c - collection of ints
"""
# import collections
import sys
from collections import defaultdict
from bisect import bisect_left, bisect_right
import decimal


# recursion increase
# sys.setrecursionlimit(10000)

# number with big precision
# from decimal
# getcontext().prec = 10_000


# input parser
# n, d, li, ld, ls, s - int, float, list of ints, list of floats, list of string, string
# lists are lines with ' '(space) delimiters

def get_ints():
    return map(int, sys.stdin.readline().strip().split())


def main():
    t = int(input())

    f = []
    MOD = 10 ** 9 + 7
    for i in range(2 * 10**5 + 11):
        if i < 10:
            f.append(1)
        else:
            f.append((f[i - 9] + f[i - 10]) % MOD)

    for _ in range(t):
        n, m = get_ints()
        ans = 0
        while n != 0:
            ans = (ans + f[n % 10 + m]) % MOD
            n //= 10

        print(ans)


if __name__ == "__main__":
    main()
