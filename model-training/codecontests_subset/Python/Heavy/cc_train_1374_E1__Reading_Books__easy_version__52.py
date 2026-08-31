#!/usr/bin/env python
import os
import sys
from io import BytesIO, IOBase
from bisect import bisect_left,bisect_right
import threading 
from collections import Counter,defaultdict  
arr=[]
 
 
 
 
def main():
 
    for _ in range(1):
        n,k=map(int,input().split())
        ar3=[]
        ar1=[]
        ar2=[]
        for i in range(n):
            a,b,c=map(int,input().split())
            if b==c==1:
                ar3.append(a)
            else:
                if b==1:
                    ar1.append(a)
                if c==1:
                    ar2.append(a)
        t=2*max(0,k-len(ar3))+len(ar3)
        if len(ar3)+len(ar1)<k or len(ar3)+len(ar2)<k:
            print(-1)
        else:
            ar3.sort()
            ar1.sort()
            ar2.sort()
            # print(ar1,ar2,ar3) 
            pt1=pt2=0
            i1=0
            i2=0
            i3=0
            ans=0
            m_=0
            while i1<len(ar1) and i2<len(ar2) and i3<len(ar3):
                if ar1[i1] + ar2[i2] <ar3[i3]:
                
                    ans=ans+ar1[i1]+ar2[i2]
                    i1+=1
                    i2+=1
                else:
 
                    ans=ans+ar3[i3]   
                    i3+=1
 
                pt1+=1
                pt2+=1
                if pt1==pt2==k:
                    break
            # print(pt1,pt2,i1,i2,i3)
            if i2>=len(ar2):
                i1,i2=i2,i1
                ar1,ar2=ar2,ar1
            while pt1<k:
                if i1<len(ar1) and i3<len(ar3) and ar3[i3]<ar1[i1]:
                    ans+=ar3[i3]
                    i3+=1
                    pt2+=1
 
                elif i1<len(ar1) :
 
                    ans+=ar1[i1]
                    i1+=1
                else:
                    
                    ans+=ar3[i3]
                    i3+=1
                    pt2+=1
 
                pt1+=1
 
            while pt2<k:
                if i1<len(ar1) and i3<len(ar3) and ar3[i3]<ar1[i1]:
                    ans+=ar3[i3]
                    i3+=1
                elif i2<len(ar2) :
                    
                    ans+=ar2[i2]
                    i2+=1
                else:
                    ans+=ar3[i3]
                    i3+=1
                pt2+=1
            print(ans)
 
 
 
 
 
                
 
 
       
 
 
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
 
# endregion
 
if __name__ == "__main__":
    main()