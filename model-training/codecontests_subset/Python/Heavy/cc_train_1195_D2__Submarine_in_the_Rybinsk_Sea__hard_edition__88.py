# Legends Always Come Up with Solution
# Author: Manvir Singh

import os
import sys
from io import BytesIO, IOBase

def main():
    n=int(input())
    a=list(map(int,input().split()))
    tmp = [[0 for _ in range(20)] for _ in range(10)]
    for i in range(n):
        s = [0 for j in range(10)]
        ss = str(a[i])
        for j in range(10):
            if j < len(ss):
                s[9 - j] = ord(ss[len(ss) - j - 1])
            else:
                s[9 - j] = 58 + j - len(ss)
        for j in range(10):
            tmp[j][s[9 - j] - 48] += 1
    asd = 0
    asd2 = 0
    for i in range(10):
        tp = 0
        for j in range(10):
            for k in range(10, 20):
                if tmp[i][k] != 0 and tmp[i][j] != 0:
                    asd2 = (asd2 + j * tmp[i][j] * 2 * tmp[i][k] * pow(10, i * 2 - (k - 10))) % 998244353
            for k in range(10):
                tp += (10 * j + k) * tmp[i][k] * tmp[i][j]
        asd = (asd + tp * pow(100, i)) % 998244353
    print((asd + asd2) % 998244353)

# FASTIO REGION

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

if __name__ == "__main__":
    main()