####################################################
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
#######################################
from collections import defaultdict as dd
from bisect import bisect_left
for t in range(int(input())):
    n,m=map(int,input().split())
    l=list(map(int,input().split()))
    q=list(map(int,input().split()))
    b=sum(l)
    d=dd(list)
    a=0
    x=0
    c=0
    for i in range(n):
        c+=l[i]
        d[c].append(i)
        if c>a:
            a=c
            x=i
    l1=[]
    for i in d:
        l1.append(i)
    l1.sort()
    y=n
    l2=[n]*len(l1)
    for i in range(len(l1)-1,-1,-1):
        for j in d[l1[i]]:
            y=min(y,j)
        l2[i]=y
    ans=[-1]*m
    for i in range(m):
        if a<q[i] and b<=0:
            continue
        if q[i]<=a:
            ans[i]=l2[bisect_left(l1,q[i])]
            
        else:
            c=q[i]-a
            e=c//b
            f=c%b
            if not f:
                ans[i]=e*n+x
            else:
                p=b*(e+1)
                r=(q[i]-p)
                z=bisect_left(l1,r)
                if z!=len(l1):
                    x1=(e+1)*n+l2[z]
                else:
                    x1=10**18
                e=q[i]//b
                f=q[i]%b
                if not f:
                    ans[i]=e*n-1
                else:
                    z=bisect_left(l1,f)
                    ans[i]=min(x1,e*n+l2[z])
                p=b*(e-1)
                r=q[i]-p
                z=bisect_left(l1,r)
                if z!=len(l1):
                    x1=(e-1)*n+l2[z]
                else:
                    x1=10**18
                while ans[i]>x1 and q[i]-b*(e-1)<=a:
                    e-=1
                    p=b*(e-1)
                    r=q[i]-p
                    z=bisect_left(l1,r)
                    if z!=len(l1):
                        x1=(e-1)*n+l2[z]
                ans[i]=min(ans[i],x1)
    print(*ans)
    
