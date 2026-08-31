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


def input(): return sys.stdin.readline().rstrip("\r\n")


# n = int(input())

# li = [int(i) for i in input().split()]

# s = sorted(li)
t = int(input())


for ti in range(t):
    li = []
    n = int(input())
    for ni in range(n):
        s = list(input())
        li.append(s)
    ans = []
    if li[0][1] == li[1][0]:
        if li[1][1] == li[0][2] == li[2][0]:
            if li[1][1] == li[0][1]:
                ans.append((0,1))
                ans.append((1,0))
            else:
                pass
        else:
            for x,y in [(1,1),(0,2),(2,0)]:
                if li[x][y] == li[0][1]:
                    ans.append((x,y))
    else:
        if li[1][1] == li[0][2] == li[2][0]:
            if li[1][1] == li[0][1]:
                ans.append((0,1))
            else:
                ans.append((1,0))
        else:
            d = {}
            for x,y in [(1,1),(0,2),(2,0)]:
                d[li[x][y]] = d.get(li[x][y],0) + 1
            if d['0'] > d['1']:
                for x,y in [(1,1),(0,2),(2,0)]:
                    if li[x][y] == '1':
                        ans.append((x,y))
                        li[x][y] = '0'
            else:
                for x,y in [(1,1),(0,2),(2,0)]:
                    if li[x][y] == '0':
                        ans.append((x,y))
                        li[x][y] = '1'
            for x,y in [(0,1),(1,0)]:
                if li[x][y] == li[1][1]:
                    ans.append((x,y))
    print(len(ans))
    for x,y in ans:
        print(x+1, y+1)
