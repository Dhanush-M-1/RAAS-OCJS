# Legends Always Come Up with Solution
# Author: Manvir Singh

import os
from io import BytesIO, IOBase
import sys
from collections import defaultdict, deque, Counter
from math import sqrt, pi, ceil, log, inf, gcd, floor
from itertools import combinations

def main():
    for _ in range(int(input())):
        a,b=input().split()
        if a<b:
            print(a)
        else:
            n=len(a)
            m=len(b)
            dp=[[0 for _ in range(26)] for i in range(n+1)]
            for i in range(n):
                dp[i+1][ord(a[i])-65]+=1
            for i in range(1,n+1):
                for j in range(26):
                    dp[i][j]+=dp[i-1][j]
            ind,first=-1,-1
            for i in range(min(n,m)):
                if a[i]>=b[i]:
                    for j in range(ord(b[i])-65):
                        if dp[-1][j]-dp[i+1][j]>=1:
                            ind=i
                            break
                    if first==-1 and a[i]>b[i]:
                        first=i
                    if ind!=-1 or a[i]>b[i]:
                        break
            if ind==-1:
                if first==-1:
                    print("---")
                else:
                    mi="Z"
                    for i in range(first+1,n):
                        if a[i]<=b[first]:
                            if mi>=a[i]:
                                ind=i
                                mi=a[i]
                    if ind==-1:
                        print("---")
                    else:
                        a=list(a)
                        a[ind],a[first]=a[first],a[ind]
                        a="".join(a)
                        if a<b:
                            print(a)
                        else:
                            print("---")
            else:
                f=0
                for i in range(ind+1,n):
                    if a[i]<b[ind]:
                        f=i
                        break
                a=list(a)
                a[ind],a[f]=a[f],a[ind]
                print("".join(a))


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