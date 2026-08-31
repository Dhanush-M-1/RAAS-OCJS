#!/usr/bin/env python
from __future__ import division, print_function

from collections import Counter
from string import ascii_uppercase

import os
import sys
from io import BytesIO, IOBase

if sys.version_info[0] < 3:
    from __builtin__ import xrange as range
    from future_builtins import ascii, filter, hex, map, oct, zip


def main():
    t = int(input())
    for _ in range(t):
        s, c =  input().split()
        s = list(s)
        count = Counter(s)
        swapMade = False
        for i in range(len(s)):
            count[s[i]] -= 1
            if i >= len(c):
                print("---")
                break
            if s[i] < c[i]:
                print("".join(s))
                break
            if swapMade and s[i] < c[i]:
                print("---")
                break
            swapChar = None
            if not swapMade:
                for char in ascii_uppercase:
                    if char < c[i]:
                        if count[char] > 0:
                            swapChar = char
                            break
                if swapChar != None:
                    curIndex = i + 1
                    while curIndex < len(s) and s[curIndex] != swapChar:
                        curIndex += 1
                    s[i], s[curIndex] = s[curIndex], s[i]
                    print("".join(s))
                    break
                elif s[i] != c[i] and count[c[i]] > 0:
                    indices = [idx for idx in range(i + 1, len(s)) if s[idx] == c[i]]
                    for index in indices:
                        s[i], s[index] = s[index], s[i]
                        if "".join(s) < c:
                            print("".join(s))
                            break
                        else:
                            s[i], s[index] = s[index], s[i]
                    else:
                        print("---")
                        break
                    break
            if s[i] != c[i]:
                print("---")
                break
        else:
            print("".join(s)) if len(c) > len(s) else print("---")


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


def print(*args, **kwargs):
    """Prints the values to a stream, or to sys.stdout by default."""
    sep, file = kwargs.pop("sep", " "), kwargs.pop("file", sys.stdout)
    at_start = True
    for x in args:
        if not at_start:
            file.write(sep)
        file.write(str(x))
        at_start = False
    file.write(kwargs.pop("end", "\n"))
    if kwargs.pop("flush", False):
        file.flush()


if sys.version_info[0] < 3:
    sys.stdin, sys.stdout = FastIO(sys.stdin), FastIO(sys.stdout)
else:
    sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)

input = lambda: sys.stdin.readline().rstrip("\r\n")

# endregion

if __name__ == "__main__":
    main()