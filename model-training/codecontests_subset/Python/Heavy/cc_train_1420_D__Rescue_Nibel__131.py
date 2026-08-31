# Legends Always Come Up with Solution
# Author: Manvir Singh

import os
from io import BytesIO, IOBase
import sys
from collections import defaultdict,deque,Counter
from bisect import *
from math import sqrt
import math
from itertools import permutations

def main():
    mod=998244353
    n,k=map(int,input().split())
    f=[1]
    invfac=[0]*(n+1)
    for i in range(1,n+1):
        f.append((i*f[-1])%mod)
    invfac[-1]=pow(f[-1],mod-2,mod)
    for i in range(n-1,-1,-1):
        invfac[i]=((i+1)*invfac[i+1])%mod
    a=[]
    for i in range(n):
        x,y=map(int,input().split())
        a.append((x,1))
        a.append((y,-1))
    a.sort(key=lambda x:x[0]*(10000000000)-x[1])
    b=0
    ans=0
    for i in a:
        if i[1]==1:
            if b>=k-1:
                ans=(ans+f[b]*invfac[b-k+1]*invfac[k-1])%mod
        b+=i[1]
    print(ans)
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
input = lambda: sys.stdin.readline().rstrip("\r\n")

if __name__ == "__main__":
    main()