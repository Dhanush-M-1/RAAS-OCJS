# -*- coding: utf-8 -*-
import os
import sys
from io import BytesIO, IOBase
INF = 2**62-1

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


def input():
    return sys.stdin.readline().rstrip("\r\n")

# ------------------------------


def read_int():
    return int(input())


def read_int_n():
    return list(map(int, input().split()))


def slv(N, L, R):
    k = 1
    ans = []
    for i in range(N-1):
        c = (N-1-i)*2
        if k + c >= L:
            for j in range(c//2):
                if L <= k <= R:
                    ans.append(i+1)
                k += 1
                if L <= k <= R:
                    ans.append(i+1+j+1)
                k += 1
                if k > R:
                    return ans
        else:
            k += c

    if L <= k <= R:
        ans.append(1)

    return ans





def main():
    T = read_int()
    for _ in range(T):
        N, L, R = read_int_n()
        print(*slv(N, L, R))


if __name__ == '__main__':
    main()
