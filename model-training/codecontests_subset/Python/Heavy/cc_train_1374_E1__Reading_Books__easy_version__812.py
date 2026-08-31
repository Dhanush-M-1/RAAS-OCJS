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
n,k=map(int,input().split())
l1=[]
l2=[]
l3=[]
l4=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        l3.append(t)
    elif a==1 and b==0:
        l1.append(t)
    elif a==0 and b==1:
        l2.append(t)
    else:
        l4.append(t)
l1.sort(reverse=True)
l2.sort(reverse=True)
l3.sort()
l4.sort()
ans=0
t=True
if len(l1)+len(l3)<k or len(l2) +len(l3)<k:
    print(-1)
else:
    if k>=len(l3):
        if len(l3):
            ans=sum(l3)
        else:
            ans=0
        t=False
        ln=len(l3)
    else:
        ans=sum(l3[:k])
        l3=l3[:k]
        ln=k
    if t==True:
        if min(len(l2),len(l1))>0:
            while l1[-1]+l2[-1]<=l3[-1]:
                ans-=l3[-1]
                ans+=l1[-1]+l2[-1]
                l1.pop()
                l2.pop()
                l3.pop()
                if len(l3)==0 or len(l1)==0 or len(l2)==0:
                    break
        print(ans)
    else:
        for j in range(k-ln):
            ans+=l1[-1]+l2[-1]
            l1.pop()
            l2.pop()
        if min(len(l2),len(l1),len(l3))>0:
            while l1[-1]+l2[-1]<=l3[-1]:
                ans-=l3[-1]
                ans+=l1[-1]+l2[-1]
                l1.pop()
                l2.pop()
                l3.pop()
                if len(l3)==0 or len(l1)==0 or len(l2)==0:
                    break
        print(ans)
        
        
        
    
    
    
        
