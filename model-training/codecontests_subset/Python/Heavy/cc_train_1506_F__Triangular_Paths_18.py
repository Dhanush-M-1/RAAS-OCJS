import os, sys
from io import BytesIO, IOBase
from types import GeneratorType
from bisect import bisect_left, bisect_right
from collections import defaultdict as dd, deque as dq, Counter as dc
import math, string
import heapq as h, time
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

#start_time = time.time()

def getInt(): return int(input())
def getStrs(): return input().split()
def getInts(): return list(map(int,input().split()))
def getStr(): return input()
def listStr(): return list(input())
def getMat(n): return [getInts() for _ in range(n)]
def getBin(): return list(map(int,list(input())))
def isInt(s): return '0' <= s[0] <= '9'
def ceil_(a,b): return a//b + (a%b > 0)

MOD = 10**9 + 7 

"""
It's always free to move to an odd pair; costs one to move to an even pair
If you can move from A to B you can't go back, so we sort the columns

Once we get into a 'black channel' we can move free of charge

1) If the two cells are in the same red channel, we have to swallow the entire cost

2) Otherwise the cost is the number of red channels I must cross

A channel is defined by R-C
A black channel is where R-C goes from even to odd
A red channel is where it goes from odd to even
"""

def solve():
    N = getInt()
    R = [1] + getInts()
    C = [1] + getInts()
    P = list(zip(R,C))
    P.sort()
    ans = 0
    flag = False
    for r, c in P:
        if flag:
            if r - c == r0 - c0:
                #same channel
                if (r - c) % 2 == 0:
                    ans += r - r0
            else:
                delta = (r - c) - (r0 - c0)
                if (r0 - c0) % 2 == 0:
                    ans += delta//2
                else:
                    ans += ceil_(delta,2)
        r0, c0 = r, c
        flag = True
    return ans

for _ in range(getInt()):
    print(solve())
#solve()

#print(time.time()-start_time)