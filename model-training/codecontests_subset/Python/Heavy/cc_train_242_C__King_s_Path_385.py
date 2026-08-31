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
x1,y1,x2,y2=map(int,input().split())
from collections import defaultdict,deque
adj=defaultdict(list)
n=int(input())
d=defaultdict(int)
l1=[0,0,1,1,1,-1,-1,-1]
l2=[1,-1,-1,0,1,-1,0,1]
for i in range(n):
    r,a,b=map(int,input().split())
    for j in range(a,b+1):
        d[(r,j)]=1
v=defaultdict(int)
q=deque([])
q.append((x1,y1))
v[(x1,y1)]=1
dis=defaultdict(int)
dis[(x1,y1)]=0
a=False
while len(q):
    x,y=q.popleft()
    for i in range(8):
        p1,p2=x+l1[i],y+l2[i]
        if not v[(p1,p2)] and d[(p1,p2)]==1:
            q.append((p1,p2))
            dis[(p1,p2)]=dis[(x,y)]+1
            v[(p1,p2)]=1
            if (p1,p2)==(x2,y2):
                a=True
                break
    if a:
        break
ans=dis[(x2,y2)]
if ans==0:
    print(-1)
else:
    print(ans)
    
        
    
