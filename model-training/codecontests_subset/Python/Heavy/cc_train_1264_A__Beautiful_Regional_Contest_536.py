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
    for _ in range(int(input())):
        n=int(input())
        arr=[int(k) for k in input().split()]
        if len(arr)<=9:
            print(0,0,0)
            continue
        g=0
        s=0
        b=0
        new=[]
        dic=defaultdict(int)
        for i in range(n):
            dic[arr[i]]+=1
        k=0
        for key,item in dic.items():
            if (k+item)<=(n//2):
                new.append(item)
                k+=item
            else:
                break
        #print(new)
        if len(new)<=2:
            print(0,0,0)
            continue
        j=len(new)-1
        g=new[0]
        while b<=g:
            b+=new[j]
            j-=1
        s=k-(g+b)
        if g<s and g<b:
            print(g,s,b)
        else:
            print(0,0,0)










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