# ------------------- fast io --------------------
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
# ------------------- fast io --------------------
from bisect import bisect_left
import heapq
n,k=map(int,input().split());seg=[];mod=998244353
if k==1:
    print(n)
else:
    for s in range(n):
        l,r=map(int,input().split())
        seg.append((l,r))
    fac=[1,1]
    for s in range(2,n+1):
        fac.append((fac[-1]*s)%mod)
    t=pow(fac[-1],mod-2,mod);inv=[t for s in range(n+1)]
    for s in range(n-1,-1,-1):
        inv[s]=(inv[s+1]*(s+1))%mod
    seg.sort(key=lambda x: [x[0],x[1]])
    heap=[]
    for s in range(k-1):
        heapq.heappush(heap,seg[s][1])
    ans=0
    for s in range(k-1,n):
        while len(heap)>0 and heap[0]<seg[s][0]:
            heapq.heappop(heap)
        if len(heap)>=k-1:
            r0=fac[len(heap)];r1=inv[k-1];r2=inv[len(heap)-(k-1)]
            ans+=((r0*r1)%mod)*r2;ans=ans%mod
        heapq.heappush(heap,seg[s][1])
    print(ans)