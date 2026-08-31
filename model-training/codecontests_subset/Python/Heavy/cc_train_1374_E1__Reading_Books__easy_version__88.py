
from collections import deque



# for #!/usr/bin/env python
import os
import sys
from io import BytesIO, IOBase


# region fastio

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
from bisect import bisect_left as bl
from math import log2,ceil
from itertools import permutations 
def main():

    # n = int(input())
    # l = [int(j) for j in input().split()]
    
# 3 4 240
# 60 90 120
# 80 150 80 150

    # for t in range(int(input())):
        # n = int(input())
        n,k  =[int(j) for j in input().split()]
        l = []
        for i in range(n):
            l.append([int(j) for j in input().split()])
        l.sort()
        al = []
        bl = []
        both = []
        for i in range(n):
            if l[i][1]==1 and l[i][2]==1:
                both.append(i)
            elif l[i][1]:
                al.append(i)
            elif l[i][2]:
                bl.append(i)
        a = 0
        b = 0
        c = 0
        ans = 0
        i = k
        j = k
        # print(al,bl,both)
        while(a<len(al) and b<len(bl) and c<len(both) and i>0 and j>0):
            if l[al[a]][0] <l[both[c]][0] and l[bl[b]][0]<l[both[c]][0] and l[al[a]][0]+ l[bl[b]][0]< l[both[c]][0]:
                ans+=l[al[a]][0]+ l[bl[b]][0]
                a+=1
                b+=1
            else:
                ans+=l[both[c]][0]
                c+=1
            i-=1
            j-=1
        # print(i,j,ans,"dsd")
        if i>0:
            while(c<len(both) and i>0):
                ans+=l[both[c]][0]
                c+=1
                i-=1    
                j-=1
            while(a<len(al) and i>0):
                ans+=l[al[a]][0]
                a+=1            
                i-=1
            # print(i, ans)
        if j>0:
            while(c<len(both) and j>0):
                ans+=l[both[c]][0]
                c+=1
                j-=1
                i-=1    
            while(b<len(bl) and j>0):
                ans+=l[bl[b]][0]
                b+=1            
                j-=1
        if i>0 or j>0:
            print(-1)
        else:
            print(ans)                      

        
        # print(a[0][1]+n*(a[0][0]-1))

                    # x,y,n  =[int(j) for j in input().split()]
        # a = n//x
        # if a*x+y<=n:
        #     print(a*x+y)
        # else:
        #     print((a-1)*x+y)
        




# endregion

if __name__ == "__main__":
    main()

