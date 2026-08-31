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
dp=[[0]*10 for i in range(20001)]
dp[0][0]=1
dp[0][1]=1
mod=10**9+7
dp1=[[0]*10 for i in range(20001)]
dp1[0][0]=2
dp1[0][1]=1
for i in range(1,20001):
    dp[i][0]=dp[i-1][9]+dp[i-1][0]
    dp[i][1]+=dp[i-1][9]
    dp[i][0]%=mod
    dp[i][1]%=mod
    for j in range(9,0,-1):
        dp[i][j]+=dp[i-1][j-1]+dp[i-1][j]
        dp[i][j]%=mod
        if j==9:
            dp1[i][j]=dp[i][j]
        else:
            dp1[i][j]=dp[i][j]+dp1[i][j+1]
        dp1[i][j]%=mod
    dp1[i][0]=dp[i][0]+dp1[i][1]
    dp1[i][0]%=mod
for t in range(int(input())):
    n,m=map(int,input().split())
    n=str(n)
    ans=0
    for i in n:
        if 10-int(i)>m:
            ans+=1
        else:
            a=m-10+int(i)
            b=a//10
            c=a%10
            ans+=dp1[b][0]
            ans%=mod
            if c:
                j=10-c
                ans+=dp1[b][j]
                ans%=mod         
    print(ans%mod)
                
