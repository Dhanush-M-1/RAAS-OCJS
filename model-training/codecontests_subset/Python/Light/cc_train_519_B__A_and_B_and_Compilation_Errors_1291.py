import math
from collections import Counter


def get(f):
    return map(f, input().split())


def divides(a, b):
    return a % b == 0


def diff(a, b):
    i = 0

    for j in range(len(b)):
        if a[i] != b[i]:
            return a[i]

        i += 1

    return a[-1]

def main():
    n = int(input())

    a = sorted(list(get(int)))
    b = sorted(list(get(int)))
    c = sorted(list(get(int)))

    print(diff(a, b))
    print(diff(b, c))


main()