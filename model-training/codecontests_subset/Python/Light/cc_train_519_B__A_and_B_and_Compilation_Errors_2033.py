import sys
input = sys.stdin.readline
from collections import Counter


def solve(a, b, c):
    for k in a:
        if k not in b:
            print(k)
        else:
            if a[k] != b[k]:
                print(k)

    for k in b:
        if k not in c:
            print(k)
        else:
            if b[k] != c[k]:
                print(k)


if __name__ == "__main__":
    n = int(input())
    a = dict(Counter(map(int, input().split(' '))))
    b = dict(Counter(map(int, input().split(' '))))
    c = dict(Counter(map(int, input().split(' '))))
    solve(a, b, c)