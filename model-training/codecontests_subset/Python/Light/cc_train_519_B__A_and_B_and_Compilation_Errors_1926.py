# URL: http://codeforces.com/problemset/problem/519/B

from typing import List


def parse_line() -> List[int]:
    return [int(x) for x in input().split()]


def parse_input():
    return input(), parse_line(), parse_line(), parse_line()


def solve(n: int, a: List[int], b: List[int], c: List[int]):
    return sum(a)-sum(b), sum(b)-sum(c)


if __name__ == '__main__':
    n, a, b, c = parse_input()
    print(" ".join(str(x) for x in solve(n, a, b, c)))
