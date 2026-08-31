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

testcases=int(input())

for j in range(testcases):
    n=int(input())
    vals=list(map(int,input().split()))
    #ok i have an idea, consider altered prefix and suffix sums. yeah that seems to work!
    up=[]
    prefup=0
    for s in range(n):
        prefup+=min(s,vals[s])
        up.append(prefup)
    down=[]
    prefdown=0
    for s in range(n-1,-1,-1):
        prefdown+=min(n-1-s,vals[s])
        down.append(prefdown)
    down.reverse()
    found=False
    for s in range(n):
        if s==0:
            if down[s]>=(n-1)*(n)//2:
                found=True
        elif s==n-1:
            if up[s]>=(n-1)*(n)//2:
                found=True
        else:
            length1=s+1
            length2=n-s
            if up[s]>=(length1-1)*(length1)//2 and down[s]>=(n-1-s)*(n-s)//2:
                found=True
        if found==True:
            break
    if found==False:
        print("No")
    else:
        print("Yes")