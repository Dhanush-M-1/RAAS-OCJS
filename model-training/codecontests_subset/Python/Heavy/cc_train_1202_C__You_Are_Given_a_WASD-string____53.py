# ------------------- fast io --------------------
import os
import sys
from io import BytesIO, IOBase

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

# ------------------- fast io --------------------
from math import gcd, ceil

def prod(a, mod=10**9+7):
    ans = 1
    for each in a:
        ans = (ans * each) % mod
    return ans

def lcm(a, b): return a * b // gcd(a, b)

def binary(x, length=16):
    y = bin(x)[2:]
    return y if len(y) >= length else "0" * (length - len(y)) + y

for _ in range(int(input()) if True else 1):
    #n = int(input())
    #n, k = map(int, input().split())
    #a, b = map(int, input().split())
    #c, d = map(int, input().split())
    #a = list(map(int, input().split()))
    #b = list(map(int, input().split()))
    s = input()
    x, y = 0, 0
    minx, miny = 0, 0
    maxx, maxy = 0, 0
    for i in s:
        if i == 'W':
            y += 1
        if i == 'S':
            y -= 1
        if i == 'D':
            x += 1
        if i == 'A':
            x -= 1
        minx = min(minx, x)
        maxx = max(maxx, x)
        miny = min(miny, y)
        maxy = max(maxy, y)
    ans = (maxx-minx+1)*(maxy-miny+1)
    x, y = 0, 0
    m1, m2, m3, m4 = 0, 0, 0, 0
    taken = False
    for i in s:
        if i == 'W':
            if y+1 == maxy and not taken:
                taken = True
                m3 = min(m3, y-1)
                m4 = max(m4, y-1)
            else:
                y += 1
        if i == 'S':
            y -= 1
        if i == 'D':
            x += 1
        if i == 'A':
            x -= 1
        m1 = min(m1, x)
        m2 = max(m2, x)
        m3 = min(m3, y)
        m4 = max(m4, y)
    ans = min(ans, (m2-m1+1)*(m4-m3+1))
    x, y = 0, 0
    m1, m2, m3, m4 = 0, 0, 0, 0
    taken = False
    for i in s:
        if i == 'S':
            if y - 1 == miny and not taken:
                taken = True
                m3 = min(m3, y+1)
                m4 = max(m4, y+1)
            else:
                y -= 1
        if i == 'W':
            y += 1
        if i == 'D':
            x += 1
        if i == 'A':
            x -= 1
        m1 = min(m1, x)
        m2 = max(m2, x)
        m3 = min(m3, y)
        m4 = max(m4, y)
    ans = min(ans, (m2 - m1 + 1) * (m4 - m3 + 1))
    x, y = 0, 0
    m1, m2, m3, m4 = 0, 0, 0, 0
    taken = False
    for i in s:
        if i == 'D':
            if x + 1 == maxx and not taken:
                taken = True
                m1 = min(m1, x-1)
                m2 = max(m2, x-1)
            else:
                x += 1
        if i == 'S':
            y -= 1
        if i == 'W':
            y += 1
        if i == 'A':
            x -= 1
        m1 = min(m1, x)
        m2 = max(m2, x)
        m3 = min(m3, y)
        m4 = max(m4, y)
    ans = min(ans, (m2 - m1 + 1) * (m4 - m3 + 1))
    x, y = 0, 0
    m1, m2, m3, m4 = 0, 0, 0, 0
    taken = False
    for i in s:
        if i == 'A':
            if x- 1 == minx and not taken:
                taken = True
                m1 = min(m1, x+1)
                m2 = max(m2, x+1)
            else:
                x -= 1
        if i == 'S':
            y -= 1
        if i == 'D':
            x += 1
        if i == 'W':
            y += 1
        m1 = min(m1, x)
        m2 = max(m2, x)
        m3 = min(m3, y)
        m4 = max(m4, y)
    ans = min(ans, (m2 - m1 + 1) * (m4 - m3 + 1))
    print(ans)


