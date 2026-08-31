import os
import sys
from io import BytesIO, IOBase
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
##########################################################
from collections import Counter, defaultdict
import math
import  heapq

for _ in range(int(input())):
    s=input()
    #n=len(s)
    #n=int(input())
    k,n,m=map(int, input().split())
    a =list(map(int, input().split()))
    b=list(map(int, input().split()))
    i=0
    j=0
    f=0
    ls=[-1]*(n+m)
    for y in range(n + m):
        if i<n and a[i]<=k:
            if a[i]==0:
                k+=1
            ls[y]=a[i]
            i+=1

        elif j<m and b[j]<=k:
            if b[j]==0:
                k+=1
            ls[y]=b[j]
            j+=1
        else:
            f=1
            break

    if f==1:
        print(-1)
    else:
        print(*ls)
    '''ac=[0]*(n+m)
    cnt=a.count(0)+b.count(0)
    for i in range(cnt,n+m):

    print(*ac)'''



















