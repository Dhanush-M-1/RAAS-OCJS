import bisect
import os
import gc
import sys
from io import BytesIO, IOBase
from collections import Counter
from collections import deque
import heapq
import math
import statistics

def sin():
    return input()

def ain():
    return list(map(int, sin().split()))

def sain():
    return input().split()

def iin():
    return int(sin())


MAX = float('inf')
MIN = float('-inf')
MOD = 1000000007

def readTree(n, m):
    adj = [deque([]) for _ in range(n+1)]
    for _ in range(m):
        u,v = ain()
        adj[u].append(v)
        adj[v].append(u)
    return adj

def main():
    n, k = ain()
    d = deque([])
    a = 0
    b = 0
    for _ in range(n):
        x = ain()
        if x[1] == 1:
            a += 1
        if x[2] == 1:
            b += 1
        d.append(x)
    if a < k or b < k:
        print(-1)
    else:
        both = deque([])
        a = deque([])
        b = deque([])
        for i in range(n):
            if d[i][1] == 1 and d[i][2] == 1:
                both.append(d[i][0])
            elif d[i][1] == 1 and d[i][2] == 0:
                a.append(d[i][0])
            elif d[i][1] == 0 and d[i][2] == 1:
                b.append(d[i][0])
        a = sorted(a)
        b = sorted(b)
        for i in range(min(len(a), len(b))):
            both.append(a[i]+b[i])
        both = sorted(both)
        print(sum(both[0:k]))
        
        




            

        
    

        







# Fast IO Template starts

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

# Fast IO Template ends

if __name__ == "__main__":
    main()
