# link: https://codeforces.com/contest/1547/problem/C

import os, sys
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
from math import ceil
mod = 10 ** 9 + 7 

# number of test cases
for _ in range(int(input())):
    input()
    k,n,m = map(int, input().split())
    mono = list(map(int, input().split()))
    poly = list(map(int, input().split()))
    order = []
    i,j = 0,0
    flag = 0
    while i < n or j < m:
        flag = 0
        while i < n:
            if mono[i] == 0:
                k += 1
                i += 1
                order.append(0)
            elif mono[i] <= k:
                order.append(mono[i])
                i += 1   
            elif mono[i] > k:
                while j < m:
                    if poly[j] == 0:
                        order.append(0)
                        j += 1
                        k += 1
                    elif poly[j] <= k:
                        order.append(poly[j])
                        j += 1    
                    else:
                        break
                if mono[i] <= k:
                    order.append(mono[i])
                    i += 1
                else:
                    flag = 1
                    break    
        if flag:
            break            
        while j < m:
            if poly[j] == 0:
                k += 1
                j += 1
                order.append(0)
            elif poly[j] <= k:
                order.append(poly[j])
                j += 1
            elif poly[j] > k:
                while i < n:
                    if mono[i] == 0:
                        order.append(0)
                        j += 1
                        k += 1
                    elif mono[i] <= k:
                        order.append(mono[i])
                        i += 1
                    else:
                        break
                if poly[j] <= k:
                    order.append(poly[j])
                    j += 1
                else:
                    flag = 1
                    break
        if flag:
            break            
    if flag:
        print(-1)
    else:
        print(*order)        



    