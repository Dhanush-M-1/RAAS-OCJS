#!/usr/bin/env python
import os
import sys
from io import BytesIO, IOBase
import threading 
from bisect import bisect_right
from heapq import heapify,heappush,heappop

def main():
    for _ in range(int(input())):
        n,l,r=map(int,input().split())
        l-=1
        ptrn=[]
        for i in range(2,10**5+2):
            ptrn.append(1)
            ptrn.append(i)

        # print(ptrn[:10])
        lth=2*(n-1)  
        ans=[]
        sf=0
        ps=0
        while lth>0:
            # print(lth,sf,lth,max(ps,l),min(r,ps+lth))
            for i in range(max(ps,l),min(r,ps+lth)):
                ans.append(ptrn[i-ps]+sf)
            ps+=lth
            lth-=2
            sf+=1


        if r==n*(n-1)+1:
            ans.append(1)
        print(*ans)





 
 
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
 
# endregion
 
if __name__ == "__main__":
    main()