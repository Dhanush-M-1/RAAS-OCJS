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
import math
import bisect
#for _ in range(int(input())):
from collections import  Counter
#sys.setrecursionlimit(10**6)
#dp=[[-1 for i in range(n+5)]for j in range(cap+5)]
#arr= list(map(int, input().split()))
#n,m= map(int, input().split())
#arr= list(map(int, input().split()))
#for _ in range(int(input())):
import bisect
#n=int(input())
#for _ in range(int(input())):
from  collections import deque
#n,q= map(int, input().split())
#rr =deque(map(int, input().split()))
for _ in range(int(input())):
    n = int(input())
    #n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    c = Counter(arr)
    l=sorted([i for i in c],reverse=True)

    ans=0
    m=len(l)
    p1=0
    p2=0
    p3=0
    for i in range(1):
        var=c[l[i]]
        v1=0
        j=i+1
        while j<m-2 and v1<=var:
            v1+=c[l[j]]
            j+=1
        v2=0
        while (v2<=var or (var+v1+v2+c[l[j]])<=(n//2)) and j<m-1:
            v2+=c[l[j]]
            j+=1
            #if i==0:
                #print(v2)

        if var<v1 and var<v2 and (var+v1+v2<=n//2) and v2>0 and v1>0:
            if var+v1+v2>ans:

                ans=var+v1+v2
                p1=var
                p2=v1
                p3=v2
    print(*[p1,p2,p3])








