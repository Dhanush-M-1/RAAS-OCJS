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
 
 
 

a=int(input())
s=input()

count=[[0 for i in range(len(s)+1)] for i in range(26)]
for i in range(len(s)):
    t=ord(s[i])-97
    for j in range(26):
        if(j==t):
            count[j][i+1]=count[j][i]+1
        else:
            count[j][i+1]=count[j][i]
ans=[]
t1=[0 for i in range(a+1)]

for i in range(26):
    ans.append(t1.copy())
f=int(input())
l=0
r=0
for l in range(len(s)):
    for r in range(l,len(s)):
        for i in range(26):
            
            y=count[i][r+1]-count[i][l]
            er=r-l+1-y
            ans[i][er]=max(r-l+1,ans[i][er])
            


for i in range(26):
    for j in range(1,len(ans[i])):
        ans[i][j]=max(ans[i][j],ans[i][j-1])
for i in range(f):
    x,s=map(str,input().split())
    print(ans[ord(s)-97][int(x)])
    
