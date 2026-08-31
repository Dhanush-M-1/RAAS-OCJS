# Legends Always Come Up with Solution
# Author: Manvir Singh

import os
from io import BytesIO, IOBase
import sys
from collections import defaultdict,deque,Counter
from bisect import *
from math import sqrt,pi,ceil,log
import math
from itertools import permutations
from copy import deepcopy
from sys import setrecursionlimit


def main():
    n=int(input())
    a=list(map(int,input().split()))
    z=len(set(a))
    if z==1 or n==2:
        print(-1)
    elif z==2 and (a[0]==a[-1] and n==3):
        print(-1)
    else:
        ind=0
        for i in range(n-1):
            if a[i]!=a[i+1]:
                ind=i
                a[i],a[i+1]=a[i+1],a[i]
                break
        x,y,w=0,0,0
        for i in range(n-1):
            if a[i]>a[i+1]:
                x+=1
            elif a[i]<a[i+1]:
                y+=1
            else:
                w+=1
        if y+w==n-1:
            if ind==n-2:
                print(-1)
            else:
                a[ind+1],a[ind]=a[ind],a[ind+1]
                for i in range(ind+1,n-1):
                    if a[i]!=a[i+1]:
                        print(i+1,i+2)
                        break
        elif x+w==n-1:
            if ind==n-2:
                print(-1)
            else:
                a[ind + 1], a[ind] = a[ind], a[ind + 1]
                for i in range(ind+1,n-1):
                    if a[i]!=a[i+1]:
                        print(i+1,i+2)
                        break
        else:
            print(ind+1,ind+2)

                        
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