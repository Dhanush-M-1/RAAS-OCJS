"""
If FastIO not needed, used this and don't forget to strip
import sys, math
input = sys.stdin.readline
"""

import os
import sys
from io import BytesIO, IOBase
import heapq as h 
from bisect import bisect_left, bisect_right

from types import GeneratorType
BUFSIZE = 8192
class FastIO(IOBase):
    newlines = 0
 
    def __init__(self, file):
        import os
        self.os = os
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None
 
    def read(self):
        while True:
            b = self.os.read(self._fd, max(self.os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()
 
    def readline(self):
        while self.newlines == 0:
            b = self.os.read(self._fd, max(self.os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()
 
    def flush(self):
        if self.writable:
            self.os.write(self._fd, self.buffer.getvalue())
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
 
import time
start_time = time.time()

import collections as col
import math, string
from functools import reduce

def getInts():
    return [int(s) for s in input().split()]

def getInt():
    return int(input())

def getStrs():
    return [s for s in input().split()]

def getStr():
    return input()

def listStr():
    return list(input())

MOD = 10**9+7

"""
Make both cells adjacent to the start equal to X, and both adjacent to the finish equal to 1-X
"""

def solve():
    N = getInt()
    S = []
    for n in range(N):
        S.append(getStr())
    ans = 0
    inv = []
    S1, S2 = int(S[0][1]), int(S[1][0])
    E1, E2 = int(S[N-1][N-2]), int(S[N-2][N-1])
    if S1 == S2:
        targ = 1-S1
        if E1 != targ:
            ans += 1
            inv.append((N,N-1))
        if E2 != targ:
            ans += 1
            inv.append((N-1,N))
    elif E1 == E2:
        targ = 1-E1
        if S1 != targ:
            ans += 1
            inv.append((1,2))
        if S2 != targ:
            ans += 1
            inv.append((2,1))
    else:
        ans = 2
        targ = 1-S1
        inv.append((2,1))
        if E1 != targ:
            inv.append((N,N-1))
        else:
            inv.append((N-1,N))
    print(ans)
    for op in inv:
        print(*op)
    return
    
for _ in range(getInt()):    
    solve()