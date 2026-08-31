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
import math
n=int(input());mod=998244353
vals=[[int(i) for i in k] for k in input().split()]
#only the lengths of the digits matter i think
#the length of the digit is at most 9 so O(2*9n) time
length=[0 for s in range(10)]
for i in range(n):
    digits=len(vals[i])
    length[digits-1]+=1
ans=0
#this is for the last entry
for i in range(n):
    digits=len(vals[i])
    for s in range(10):
        cv=0;count=0
        if digits-2<=s:
            #if the digit is less than or equal to the number before it
            for b in range(digits-1,-1,-1):
                count+=vals[i][b]*pow(10,cv,mod)
                count=count%mod
                cv+=2
        else:
            count+=vals[i][-1]
            cv+=2
            #then the digit is greater than the number before it
            for b in range(digits-2,digits-3-s,-1):
                count+=vals[i][b]*pow(10,cv,mod)
                count=count%mod
                cv+=2
            cv-=1
            for b in range(digits-3-s,-1,-1):
                count+=vals[i][b]*pow(10,cv,mod)
                count=count%mod
                cv+=1
        ans+=(count*length[s])%mod
        ans=ans%mod
#first entry now
for i in range(n):
    digits=len(vals[i])
    for s in range(10):
        cv=1;count=0
        if digits-1<=s:
            #if the digits is less than or equal to s
            for b in range(digits-1,-1,-1):
                count+=vals[i][b]*pow(10,cv,mod)
                count=count%mod
                cv+=2
        else:
            #digits are greater than s
            for b in range(digits-1,digits-2-s,-1):
                count+=vals[i][b]*pow(10,cv,mod)
                count=count%mod
                cv+=2
            cv-=1
            for b in range(digits-2-s,-1,-1):
                count+=vals[i][b]*pow(10,cv,mod)
                count=count%mod
                cv+=1
        ans+=(count*length[s])%mod
        ans=ans%mod
print(ans)