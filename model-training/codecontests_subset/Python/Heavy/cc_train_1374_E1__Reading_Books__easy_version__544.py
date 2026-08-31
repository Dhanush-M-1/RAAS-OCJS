#!/usr/bin/env python
import os
import operator
from collections import defaultdict
import sys
from io import BytesIO, IOBase
import bisect

# def power(x, p):
#     res = 1
#     while p:
#         if p & 1:
#             res = res * x % 1000000007
#         x = x * x % 1000000007
#         p >>= 1
#     return res;

def main():
    n,el=map(int,input().split())
    oo=[]
    zo=[]
    oz=[]

    for i in range(n):
        t,a,b=map(int,input().split())
        if a==b==1:
            oo.append(t)
        elif a==1 and b==0:
            oz.append(t)
        elif a==0 and b==1:
            zo.append(t)
    oo.sort()
    zo.sort()
    oz.sort()


    alice=0
    bob=0
    i=0
    j=0
    k=0
    ans=0
    while True:
        if alice>=el and bob>=el:
            break
        if i < len(oo) and j < len(oz) and k < len(zo):
            if oo[i] < (oz[j] + zo[k]):
                ans += oo[i]
                alice += 1
                bob += 1
                i += 1
            else:
                ans += oz[j] + zo[k]
                alice += 1
                bob += 1
                j += 1
                k += 1
        elif i < len(oo):
            ans += oo[i]
            alice += 1
            bob += 1
            i += 1
        elif j < len(oz) and k < len(zo):
            ans += oz[j] + zo[k]
            alice += 1
            bob += 1
            j += 1
            k += 1
        else:
            break
    if alice >= el and bob >= el:
        print(ans)
    else:
        print(-1)























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