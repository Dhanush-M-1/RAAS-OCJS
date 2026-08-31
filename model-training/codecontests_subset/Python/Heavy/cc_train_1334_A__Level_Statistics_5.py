
def main():
    for _ in inputt():
        flag = True
        p = c = 0
        for _ in inputt():
            np, nc = inputi()
            if not flag: continue
            if np < nc or np < p or nc < c:
                flag = False
            elif np - p < nc - c:
                flag = False
            p, c = np, nc
        if flag:
            print("YES")
        else:
            print("NO")


# region M

# region fastio

import sys, io, os
BUFSIZE = 8192
class FastIO(io.IOBase):
    newlines = 0
    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = io.BytesIO()
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
class IOWrapper(io.IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")
def print(*args, **kwargs):
    for x in args:
        file.write(str(x))
    file.write(kwargs.pop("end", "\n"))
 
sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

# endregion

# region import

inputt = lambda t = 0: range(t) if t else range(int(input()))
inputi = lambda: map(int, input().split())
inputl = lambda: list(inputi())
from math import *
from heapq import *
from bisect import *
from itertools import *
from functools import reduce, lru_cache
from collections import Counter, defaultdict
import re, copy, operator, cmath
from builtins import *

# endregion

# region main

if __name__ == "__main__":
    main()

# endregion

# endregion