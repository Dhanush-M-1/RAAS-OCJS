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
 
n,m=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
#now we count residuals of a and b
dicta={}
dictb={}
for j in range(n):
    resa=a[j]%m
    resb=b[j]%m
    if not(resa in dicta):
        dicta[resa]=1
    elif resa in dicta:
        dicta[resa]+=1
    if not(resb in dictb):
        dictb[resb]=1
    elif resb in dictb:
        dictb[resb]+=1
#now we count the reps
repa=[(dicta[k],k) for k in dicta.keys()]
repa.sort(key= lambda x: x[1])
repb=[(dictb[k],k) for k in dictb.keys()]
repb.sort(key= lambda x: x[1])
#ok we check if they're equal
#ok we will cycle through it liek we did before
minsofar=m+1
for j in range(len(repa)):
    broke=False
    init=(repb[j][1]-repa[0][1])%m
    for s in range(len(repa)):
        if not((repb[(s+j)%len(repb)][1]-repa[s][1])%m==init and repb[(s+j)%len(repb)][0]==repa[s][0]):
            broke=True
            break
    if broke==False:
        val=(repb[j][1]-repa[0][1])%m
        if val<minsofar:
            minsofar=val
print(minsofar)