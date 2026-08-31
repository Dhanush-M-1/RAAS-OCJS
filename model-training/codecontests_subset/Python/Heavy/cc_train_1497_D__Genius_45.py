"""
#If FastIO not needed, use this and don't forget to strip
#import sys, math
#input = sys.stdin.readline
"""

import os, sys, heapq as h, time
from io import BytesIO, IOBase
from types import GeneratorType
from bisect import bisect_left, bisect_right
from collections import defaultdict as dd, deque as dq, Counter as dc
import math, string
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
def isInt(s): return '0' <= s[0] <= '9'

MOD = 10**9 + 7 

"""
IQ < |ci - cj|
So the jump in problem must be > IQ
Eventually your IQ will exceed the biggest jump

Max number of goes I can have is 25

You must make a bigger leap each time

So, we're going to tour all edges in such a way that 
I go forwards one edge at a time
I can go backwards to any point other than the one I've just visited, but I must then go further forwards

So I go backwards then forwards if both the following are true
1) I can
2) It's better to do so

I'm only going to have to stop at the last node, if reached from 

Start at the bottom
While the colour is the same as the one above, move along with no score change

I can either go directly forward, or I can go forward via a back edge

dp[i][j] is the best I can do from node i having arrived from node j
dp[N][1] = 0
dp[N][2] = abs(SN-S1)
dp[N][3] = max(abs(SN-S2),abs(SN-S1))
etc
dp[N-1][1] = f(N-1,1) + dp[N][N-1]
dp[N-1][2] = max(f(N-1,1)+dp[1][N-1],f(N,N-1)+dp[N][N-1])
dp[N-1][3] = max(dp[N-1][2]
"""

def solve():
    N = getInt()
    tags = getInts()
    S = getInts()
    ans = 0
    dp = [0]*N
    for i in range(N):
        for j in range(i-1,-1,-1):
            if tags[i] != tags[j]:
                tmp = dp[j]
                dp[j] = max(dp[j], dp[i] + abs(S[j]-S[i]))
                dp[i] = max(dp[i], tmp + abs(S[j]-S[i]))
    return max(dp)
    
for _ in range(getInt()):
    print(solve())
#solve()

#print(time.time()-start_time)