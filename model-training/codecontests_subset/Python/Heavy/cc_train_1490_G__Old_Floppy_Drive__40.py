import os
import sys
from bisect import bisect_left
from collections import Counter
from io import BytesIO, IOBase
from math import ceil


def f(n):
    return int(n)%3
def main():
    from collections import Counter

    for _ in range(int(input())):
        n, m = map(int, input().split())
        a = [int(X) for  X in input().split()]

        pre = [a[0]]
        tt = a[0]
        y = sum(a)
        for i in range(1, n):
            tt += a[i]
            pre.append(max(pre[-1], tt))
        mn = []

        qq=[int(X) for X in input().split()]
        for j in qq:
            if y <= 0:
                op = bisect_left(pre, j)
                mn.append(-1 if op == n else op )


            else:
                tmp = max(0, j - pre[-1])
                j -= ceil(tmp / y) * y


                op = bisect_left(pre, j)
                mn.append(op + n * ceil(tmp / y))
        print(*mn)
#Fast IO Region
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

if __name__ == '__main__':
    main()
