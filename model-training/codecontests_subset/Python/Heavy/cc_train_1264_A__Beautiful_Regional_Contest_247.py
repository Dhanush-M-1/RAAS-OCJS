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
    dict1={}
    for s in range(n):
        if not(vals[s] in dict1):
            dict1[vals[s]]=1
        else:
            dict1[vals[s]]+=1
    keys=[k for k in dict1]
    keys.sort()
    keys.reverse()
    count=0
    index=0
    for s in range(len(keys)):
        if count+dict1[keys[s]]<=n//2:
            count+=dict1[keys[s]]
            index=s
        else:
            break
    outy=[0,0,0]
    for s in range(index+1):
        if s==0:
            outy[0]+=dict1[keys[s]]
        else:
            if outy[0]>=outy[1]:
                outy[1]+=dict1[keys[s]]
            else:
                outy[2]+=dict1[keys[s]]
    if outy[0]>=outy[1] or outy[0]>=outy[2]:
        print("0 0 0")
    else:
        outy=[str(k) for k in outy]
        print(" ".join(outy))