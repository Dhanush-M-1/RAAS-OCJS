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
import math
if __name__ == '__main__':
    n,k = map(int,input().split())
    on = list()
    off = list()
    for j in  range(n):
        l1,r1 = map(int,input().split())
        on.append(l1)
        off.append(r1)
    on.sort()
    off.sort()
    f = [1]
    for i in range(1,n+1):
        f.append((f[-1]*i)%998244353)
    inv = [pow(i,998244351,998244353) for i in f]
    j = 0
    ans = 0
    count = 0
    i = 0
    while i<n:
        while on[i]<=off[j]:
            count+=1
            i+=1
            if count>k:
                ans = (ans + (f[count-1]*inv[k-1]*inv[count-k])%998244353)%998244353
            if count == k:
                ans = (ans +1)%998244353
            if i==n:
                break
        
        if i==n:
            break
        while off[j]<on[i]:
            count-=1
            j+=1
            if j == n:
                break
    print(ans)
# import math
# if __name__ == '__main__':
#     n,k = map(int,input().split())
#     a = list()
#     for _ in range(n):
#         on,off = map(int,input().split())
#         a.append(on*2)
#         a.append(off*2+1)
#     a.sort()
#     f = [1]*(3*10**5+1)
#     inv = [1]*(3*10**5+1)
#     for i in range(1,n+1):
#         f[i] = (f[i-1]*i)%998244353
#         inv[i] = (pow(f[i],998244351,998244353)%998244353)
#     count = 0
#     ans = 0
#     for j in a:
#         if j%2!=0:
#             count-=1
#         else:
#             if count>=k-1:
#                 ans += (f[count]*inv[k-1]*inv[count-k+1])%998244353
#                 ans = ans%998244353
#             count+=1
#     print(ans)
#     print(len(f))

