import sys
input = sys.stdin.readline
from collections import Counter


def solve(x, y):
    for k in x:
        if k not in y or x[k] != y[k]:
            print(k)


if __name__ == "__main__":
    n = int(input())
    a = dict(Counter(map(int, input().split(' '))))
    b = dict(Counter(map(int, input().split(' '))))
    c = dict(Counter(map(int, input().split(' '))))
    solve(a, b)
    solve(b, c)