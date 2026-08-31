#------------------------template--------------------------#
import os
import sys
from math import *
from collections import *
from fractions import *
from bisect import *
from io import BytesIO, IOBase
def vsInput():
    sys.stdin = open('input.txt', 'r')
    sys.stdout = open('output.txt', 'w')
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
def value():return tuple(map(int,input().split()))
def array():return [int(i) for i in input().split()]
def Int():return int(input())
def Str():return input()
def arrayS():return [i for i in input().split()]

#-------------------------code---------------------------#
#vsInput()

for _ in range(Int()):
    n=Int()
    a=array()
    ans=set()
    for i in range(n):
        if(a[i]!=-1 and i!=0 and a[i-1]==-1):
            ans.add(a[i])
        if(a[i]!=-1 and i!=n-1 and a[i+1]==-1):
            ans.add(a[i])
    try:ans=(min(ans)+max(ans))//2
    except:ans=0
    a1=list(map(lambda x: x if x!=-1 else ans, a))
    a2=list(map(lambda x: x if x!=-1 else ans+1, a))
    #print(a,a1)
    maxDif1,maxDif2=0,0
    for i in range(n-1):
        maxDif1=max(maxDif1,abs(a1[i]-a1[i+1]))
        maxDif2=max(maxDif2,abs(a2[i]-a2[i+1]))

    maxDif=maxDif1
    if(maxDif2<maxDif1):
        maxDif=maxDif2
        ans+=1
    print(maxDif,ans)


    