# cook your code here

import os
import sys
from math import ceil, floor, sqrt, gcd, factorial
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


def main():
    alpha=['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

    for _ in range(int(input())):
        input()
        # n=int(input())
        k,n,m=map(int,input().split())
        a=list(map(int,input().split()))#n
        b=list(map(int,input().split()))#m
        i=0;j=0
        ans=[]
        fa=True;fb=False
        pas=0
        pasf=False
        while (i<n or j<m):
            if pas>=2:
                pasf=True
                break
            if fa==True:
                if a[i]==0:
                    pas=0
                    k+=1
                    ans.append(a[i])
                    i+=1
                else:
                    if a[i]<=k:
                        pas=0
                        ans.append(a[i])
                        i+=1
                    else:
                        pas+=1
                        fa=False
                        fb=True
                if i==n:
                    for o in b[j:]:
                        if o==0:
                            ans.append(o)
                            k+=1
                        elif o<=k:
                            ans.append(o)
                        else:
                            pasf=True
                            break
                    break
            else:
                if b[j]==0:
                    pas=0
                    k+=1
                    ans.append(b[j])
                    j+=1
                else:
                    if b[j]<=k:
                        pas=0
                        ans.append(b[j])
                        j+=1
                    else:
                        pas+=1
                        fa=True
                        fb=False
                if j==m:
                
                    for o in a[i:]:
                        if o==0:
                            ans.append(o)
                            k+=1
                        elif o<=k:
                            ans.append(o)
                        else:
                            pasf=True
                            break
                    break
        
        if pasf==False:print(*ans)
        else:print(-1)
if __name__ == "__main__":
    main()
