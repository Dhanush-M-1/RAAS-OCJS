#!/usr/bin/env python
import os
import re
import sys
from bisect import bisect, bisect_left, insort, insort_left
from collections import Counter, defaultdict, deque
from copy import deepcopy
from decimal import Decimal
from fractions import gcd
from io import BytesIO, IOBase
from itertools import (
    accumulate, combinations, combinations_with_replacement, groupby,
    permutations, product)
from math import (
    acos, asin, atan, ceil, cos, degrees, factorial, hypot, log2, pi, radians,
    sin, sqrt, tan)
from operator import itemgetter, mul
from string import ascii_lowercase, ascii_uppercase, digits


def inp():
    return(int(input()))


def inlist():
    return(list(map(int, input().split())))


def instr():
    s = input()
    return(list(s[:len(s)]))


def invr():
    return(map(int, input().split()))


def isAccepted(a1, a2, a3, a4, r1, r2, c1, c2, d1, d2):
    temp = set()
    temp.add(a1)
    temp.add(a2)
    temp.add(a3)
    temp.add(a4)
    if len(temp) < 4:
        return False
    for i in temp:
        if i < 1 or i > 9:
            return False
    if a1+a2 == r1 and a3 + a4 == r2 and a1 + a3 == c1 and a2 + a4 == c2 and a1 + a4 == d1 and a2 + a3 == d2:
        return True
    else:
        return False


def main():
    # # For getting input from input.txt file
    # sys.stdin = open('input.txt', 'r')

    # # Printing the Output to output.txt file
    # sys.stdout = open('output.txt', 'w')
    r1, r2 = invr()
    c1, c2 = invr()
    d1, d2 = invr()

    for i in range(1, 10):
        a1 = i
        a2 = r1 - a1
        a3 = c1 - a1
        a4 = r2 - a3
        if isAccepted(a1, a2, a3, a4, r1, r2, c1, c2, d1, d2):
            print(a1, a2)
            print(a3, a4)
            sys.exit()
    print(-1)


# region fastio
BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
def input(): return sys.stdin.readline().rstrip("\r\n")

# endregion


if __name__ == "__main__":
    main()
