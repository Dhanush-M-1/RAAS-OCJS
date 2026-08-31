import sys
import math
from collections import defaultdict,Counter
import heapq
# input=sys.stdin.readline
# def print(x):
#     sys.stdout.write(str(x)+"\n")
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



# sys.stdout=open("CP1/output.txt",'w')
# sys.stdin=open("CP1/input.txt",'r')

def power(x,y,m):
    if y==0:
        return 1
    p=power(x,y//2,m)%m
    p=(p*p)%m
    if y%2==0:
        return p
    else:
        return((x*p)%m)

# mod=pow(10,9)+7
m=998244353
n,k=map(int,input().split())
k1=k-1
comb=[0]*(n+1)
comb[k1]=1
inv=[0]*(n+1)
inv[0]=inv[1]=1
for i in range(2,n+1):
	inv[i]=(inv[m%i]*(m-m//i))%m
# print(inv)
for j in range(k1+1,n+1):
	comb[j]=((comb[j-1]*j)%m*inv[j-k1])%m
# print(comb)
d=[]
for i in range(n):
	l,r=map(int,input().split())
	d.append((l,r))
	# d[l]+=1
	# d[r+1]-=1
d.sort()
# print(d)
s=[]
heapq.heapify(s)
ans=0
for i in range(n):
	while s and s[0]<d[i][0]:
		heapq.heappop(s)
	ans=(ans+comb[len(s)])%m
	heapq.heappush(s,d[i][1])
print(ans)