from itertools import permutations
#from fractions import Fraction
from collections import defaultdict
from math import*
import os
import sys
from io import BytesIO, IOBase
from heapq import nlargest
from bisect import*
import copy
import itertools
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

def input(): return sys.stdin.readline().rstrip("\r\n")
#-------------above part copied-----------------------

def calc(pos):
    val=0
    poss=ans.index(pos)
#    print(ans,poss,pos)
    for i in range(poss):
        val+=arr[ans[i]-1]
    temp=ans[poss]
    for i in range(poss,0,-1):
        ans[i]=ans[i-1]
    ans[0]=temp
#    print(ans)
    return val


n,m=map(int,input().split())
arr=list(map(int,input().split()))
brr=list(map(int,input().split()))

d=defaultdict(int)
ans=[]
for i in range(len(brr)):
    if d[brr[i]]==0:
        ans.append(brr[i])
        d[brr[i]]=1
#print(ans)
exp=sum(arr)
for i in range(n):
    if d[i+1]==0:
        exp-=arr[i]
anss=0
for i in range(m):
    anss+=calc(brr[i])

print(anss)

