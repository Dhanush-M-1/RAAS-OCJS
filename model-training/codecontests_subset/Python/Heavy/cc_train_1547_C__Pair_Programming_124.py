"""
from sys import stdin, stdout
import math
from functools import reduce
import statistics
import numpy as np
import itertools
import operator
from sys import stdin, stdout
import math
from functools import reduce
import statistics
import numpy as np
import itertools
import sys
import operator
from collections import Counter
import decimal
"""
import math
import os
import sys
from math import ceil, floor, sqrt, gcd, factorial
from io import BytesIO, IOBase
from collections import Counter
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
input = lambda: sys.stdin.readline().rstrip("\r\n")


def prog_name():
    input()
    lines, n, m = map(int, input().split())
    mono = list(map(int, input().split()))
    poly = list(map(int, input().split()))
    final = []
    mo = po = 0
    flag = True
    while (mo < n or po < m) and flag == True:
        if mo < n:
            if mono[mo] == 0:
                final.append(mono[mo])
                mo += 1
                lines += 1
            elif mono[mo] > 0:
                if mono[mo] <= lines:
                    final.append(mono[mo])
                    mo += 1
                else:
                    if po < m:
                        if poly[po] == 0:
                            final.append(poly[po])
                            po += 1
                            lines += 1
                        elif poly[po] > 0:
                            if poly[po] <= lines:
                                final.append(poly[po])
                                po += 1
                            else:
                                flag = False
                                break
                    else:
                        flag = False
                        break
        else:
            while po < m:
                if poly[po] == 0:
                    final.append(poly[po])
                    po += 1
                    lines += 1
                elif poly[po] > 0:
                    if poly[po] <= lines:
                        final.append(poly[po])
                        po += 1
                    else:
                        flag = False
                        break
    if flag == False:
        print(-1)
    else:
        print(*final)


def main():
    # init = time()
    T = int(input())
    for unique in range(T):
        # print("Case #"+str(unique+1)+":",end = " ")
        prog_name()
    # print(time() - init)


if __name__ == "__main__":
    main()

