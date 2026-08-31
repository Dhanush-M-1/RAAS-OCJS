import re
from collections import Counter
from sys import stderr
from typing import Union, Generator, List, Tuple
import string

INF = 2e18 + 3
EPS = 1e-10


def main():
    k = int(input())
    symbols = Counter(input())

    res = ""
    is_impossible = False
    for key, value in symbols.items():
        if value % k != 0:
            is_impossible = True
            break
        else:
            res += key * (value // k)

    print(-1 if is_impossible else res * k)


if __name__ == '__main__':
    main()
