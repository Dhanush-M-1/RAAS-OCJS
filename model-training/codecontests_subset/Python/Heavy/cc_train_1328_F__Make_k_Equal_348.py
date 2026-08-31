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

n,k = (int(i) for i in input().split(' '))
d = {}
li = []
mx = 1
for i in input().split(' '):
    ii = int(i)
    if ii not in d:
        d[ii] = 1
        li.append(ii)
    else:
        d[ii] +=1
        if d[ii] > mx:
            mx = d[ii]
            md = ii
li.sort()

tot = sum(d.values())

for i in li:
    if i==li[0]:
        _sum = [d[li[0]]]
    else:
        _sum.append(_sum[-1]+d[i])

ans = int(1e16)

for pos,i in enumerate(li):
    if d[i] >= k:
        ans = 0
        print(0)
        exit(0)
    if pos == 0:
        ansl = 0
        ansr = 0
        cur = 0
        for pj,j in enumerate(li[::-1]):
            if pj == len(li) - 1:
                break
            cur += d[j]
            ansr += cur*(j-li[-pj-2])
        #ansr += cur
        ans = min(ans,ansr-cur+k-d[i])
        ansr -= cur*(li[pos+1]-i)
        cur -= d[li[pos+1]]
    elif pos == len(li)-1:
        ansl += _sum[pos-1]*(i-li[pos-1])
        ans=min(ans,ansl-_sum[pos-1]+k-d[i])
    else:
        ansl += _sum[pos-1]*(i-li[pos-1])
        
        if _sum[pos-1] >= k-d[i]:
            ans=min(ans,ansl-_sum[pos-1]+k-d[i])
        if cur >= k-d[i]:
            ans = min(ans,ansr-cur+k-d[i])
        ans = min(ans,ansl+ansr-cur-_sum[pos-1]+k-d[i])
        ansr -= cur*(li[pos+1]-i)
        cur -= d[li[pos+1]]
print(ans)
