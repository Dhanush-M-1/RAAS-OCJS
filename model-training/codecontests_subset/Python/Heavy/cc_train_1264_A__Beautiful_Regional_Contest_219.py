import os
import sys
from io import BytesIO, IOBase
import heapq as h 
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
import math
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



"""
We need at least 1 G, 2 S, 2 B
Firstly, we need to find the the value of the first individual who definitely cannot receive a medal. This person has index N//2.
We need at least 3 distinct values in P which are greater than this. If not, impossible.
We then award as few gold medals as possible, specifically only to the highest scorers. We then award silver medals such that as few as possible are given out
subject to S > G. Then if B (the remainder) > G, we are fine. Otherwise, impossible.
"""

def solve():
    N = getInt()
    P = getInts()
    if N < 10:
        print(0,0,0)
        return
    max_not_poss = P[N//2]
    P = P[:N//2]
    while P and P[-1] == max_not_poss:
        P.pop()
    if len(set(P)) < 3:
        print(0,0,0)
        return
    P.reverse()
    G, G_val = 0, P[-1]
    while P and P[-1] == G_val:
        G += 1
        P.pop()
    if len(P) <= 2*G+1:
        print(0,0,0)
        return
    S = 0
    while S <= G:
        next_val = P.pop()
        S += 1
    while P and P[-1] == next_val:
        S += 1
        P.pop()
    B = len(P)
    if B > G:
        print(G,S,B)
        return
    print(0,0,0)
    return
    
for _ in range(getInt()):    
    solve()
