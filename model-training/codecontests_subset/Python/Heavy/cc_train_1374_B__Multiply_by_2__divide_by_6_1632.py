
from collections import deque



# for #!/usr/bin/env python
import os
import sys
from io import BytesIO, IOBase


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
from bisect import bisect_left as bl
from math import log2,ceil
from itertools import permutations 
def main():

    # n = int(input())
    # l = [int(j) for j in input().split()]
    
# 3 4 240
# 60 90 120
# 80 150 80 150

    for t in range(int(input())):
        n = int(input())
        a = 0
        b = 0
        while(n%3==0):
            n = n//3
            a+=1
        while(n%2==0):
            n = n//2
            b+=1
        ans =-1
        # print(a,b)
        if a>=b and n==1:
            ans = a-b+a
        print(ans) 
                    # x,y,n  =[int(j) for j in input().split()]
        # a = n//x
        # if a*x+y<=n:
        #     print(a*x+y)
        # else:
        #     print((a-1)*x+y)
        




# endregion

if __name__ == "__main__":
    main()

