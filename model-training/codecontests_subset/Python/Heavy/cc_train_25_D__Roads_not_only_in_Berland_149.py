# Author : nitish420 --------------------------------------------------------------------
import os
import sys
from io import BytesIO, IOBase


maxval=1000
rank=[0]*(maxval+1)
parent=[i for i in range(maxval+1)]


def find(x):
	if x==parent[x]:
		return x
	parent[x]=find(parent[x])
	# path compression in this step

	return parent[x]


def union(a,b):

	aset=find(a)
	bset=find(b)

	if aset==bset:
		return 1
	
	ra,rb=rank[aset],rank[bset]

	if ra<rb:
		aset,bset=bset,aset
	
	parent[bset]=aset

	if ra==rb:
		rank[aset]+=1

	return 0



def main():
    n=int(input())
    extra=[]
    for _ in range(n-1):
        a,b=map(int,input().split())
        if union(a,b):
            extra.append((a,b))
    
    print(len(extra))
    zz=[]
    for i in range(1,n+1):
        if parent[i]==i:
            zz.append(i)
    for i in range(len(extra)):
        print(extra[i][0],extra[i][1],zz[i],zz[i+1])


# region fastio

BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = 'x' in file.mode or 'r' not in file.mode
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
            self.newlines = b.count(b'\n') + (not b)
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
        self.write = lambda s: self.buffer.write(s.encode('ascii'))
        self.read = lambda: self.buffer.read().decode('ascii')
        self.readline = lambda: self.buffer.readline().decode('ascii')


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip('\r\n')


# endregion

if __name__ == '__main__':
    main()

# 10
# 1 2
# 2 3
# 1 3
# 4 5
# 5 6
# 4 6
# 7 8
# 8 9
# 7 9