# by the authority of GOD     author: manhar singh sachdev #

import os,sys
from io import BytesIO, IOBase
from collections import deque

def find(parent,x):
    if x == parent[x]:
        return x
    parent[x] = find(parent,parent[x])
    return parent[x]

def union(parent,a,b,rank):
    a,b = find(parent,a),find(parent,b)
    if a != b:
        if rank[a] < rank[b]:
            a,b = b,a
        parent[b] = a
        if rank[a] == rank[b]:
            rank[a] += 1
        return 1
    return 0

def main():
    n,m = map(int,input().split())
    ans,rank = [],[0]*m
    parent,inde,path = [i for i in range(m)],[0]*m,[[] for _ in range(m)]
    for i in range(1,n+1):
        x = list(map(int,input().split()))
        if x[0] == 1:
            a = x[1]-1
            if not inde[a]:
                curr = deque([a])
                while len(curr):
                    xx = curr.popleft()
                    inde[xx] = 1
                    for z in path[xx]:
                        if not inde[z]:
                            inde[z] = 1
                            curr.append(z)
                    path[xx] = []
                ans.append(i)
        else:
            a,b = x[1]-1,x[2]-1
            if (not inde[a] or not inde[b]) and union(parent,a,b,rank):
                path[a].append(b)
                path[b].append(a)
                if inde[a] or inde[b]:
                    curr = deque([a])
                    while len(curr):
                        xx = curr.popleft()
                        inde[xx] = 1
                        for z in path[xx]:
                            if not inde[z]:
                                inde[z] = 1
                                curr.append(z)
                        path[xx] = []
                ans.append(i)
    print(pow(2,len(ans),10**9+7),len(ans))
    print(*ans)

# Fast IO Region
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
if __name__ == "__main__":
    main()