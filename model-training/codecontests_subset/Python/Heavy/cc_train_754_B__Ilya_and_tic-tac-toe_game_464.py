import sys
import string

from collections import Counter, defaultdict
from math import fsum, sqrt, gcd, ceil, factorial
from itertools import combinations, permutations

# input = sys.stdin.readline
flush = lambda: sys.stdout.flush
comb = lambda x, y: (factorial(x) // factorial(y)) // factorial(x - y)


# inputs
# ip = lambda : input().rstrip()
ip = lambda: input()
ii = lambda: int(input())
r = lambda: map(int, input().split())
rr = lambda: list(r())

n = 4
arr = [ip() for i in range(n)]

for i in range(n):
    for j in range(n):
        if j + 3 <= n:
            c = 0
            for x in range(j, j + 3):
                if arr[i][x] == "x":
                    c += 1
                if arr[i][x] == "o":
                    c -= 1
            if c >= 2:
                exit(print("YES"))

        if i + 3 <= n:
            c = 0
            for x in range(i, i + 3):
                if arr[x][j] == "x":
                    c += 1
                if arr[x][j] == "o":
                    c -= 1
            if c >= 2:
                exit(print("YES"))

        if i + 3 <= n and j + 3 <= n:
            c = 0
            for x in range(3):
                if arr[i + x][j + x] == "x":
                    c += 1
                if arr[i + x][j + x] == "o":
                    c -= 1

            if c >= 2:
                exit(print("YES"))

        if i + 3 <= n and j - 2 >= 0:
            c = 0
            for x in range(3):
                if arr[i + x][j - x] == "x":
                    c += 1
                if arr[i + x][j - x] == "o":
                    c -= 1

            if c >= 2:
                exit(print("YES"))


print("NO")
