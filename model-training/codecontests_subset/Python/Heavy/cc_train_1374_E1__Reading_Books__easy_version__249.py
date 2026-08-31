#------------------------template--------------------------#
import os
import sys
from math import *
from collections import *
from fractions import *
from bisect import *
from heapq import*
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

n,k=value()

alice=[]
bob=[]
both=[]

for i in range(n):
    t,a,b=value()

    if(a==1 and b==1):
        both.append(t)
    elif(a==1):
        alice.append(t)
    elif(b==1):
        bob.append(t)

alice.sort()
bob.sort()
both.sort()

#print(alice)
#print(bob)
#print(both)
#print()
ans=0

if(len(bob)+len(both)<k or len(alice)+len(both)<k):
    print(-1)
    exit()

if(len(alice)<k):
    
    dif=k-len(alice)
    ans+=sum(both[:dif])
    both=both[dif:]
    k-=dif

if(len(bob)<k):
    dif=k-len(bob)
    ans+=sum(both[:dif])
    both=both[dif:]
    k-=dif



#print(alice)
#print(bob)
#print(both)
#print()

a=0
b=0
bo=0
for i in range(k):
    
    if(bo<len(both) and alice[a]+bob[b]>both[bo]):
        ans+=both[bo]
        bo+=1
    else:
        ans+=alice[a]+bob[b]
        a+=1
        b+=1
        
    


print(ans)





    




    
