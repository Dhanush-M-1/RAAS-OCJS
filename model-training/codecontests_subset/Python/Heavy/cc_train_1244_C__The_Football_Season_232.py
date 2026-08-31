from math import *
from sys import *
from heapq import *
from collections import defaultdict
import os, sys
from io import IOBase, BytesIO
M=10**9+7
def pow(a,b):
    res=1
    while b>0:
        if b&1:
            res*=a
        a*=a
        b>>=1
    return res
def powmod(a,b,m):
    res=1
    while b>0:
        if b&1:
            res=((res*a)%m)
        a*=a
        b>>=1
    return res
def inv(a,m):
    return powmod(a,m-2,m)
def alldivisors(n) : 
    list = []  
    arr=[]
    for i in range(1, int(sqrt(n) + 1)) :
        if (n % i == 0) : 
            if (n / i == i) : 
                arr+=[i]
            else :
                arr+=[i]
                list.append(n//i)  
    arr+=list[::-1]
    return arr
def primefactorisation(n):
    potentional_p = 3
    itog_list = defaultdict(int)
    if n % 2 == 0:
        itog_list[2] = 0
    while n % 2 == 0:
        n = n // 2
        itog_list[2] += 1
    while n - 1:
        if potentional_p > (n**0.5):
            itog_list[n] += 1
            return itog_list
        while n % potentional_p == 0:
            n = n // potentional_p
            itog_list[potentional_p] += 1
        potentional_p += 2
    return itog_list



def main():
    n,p,w,d=list(map(int,input().split()))
    gd=gcd(w,d)
    if p%gd==0:
        p=p//gd
        w=w//gd
        d=d//gd
    else:
        print(-1)
        exit(0)
    x_i=p/w
    y_i=p/d
    
    if y_i<x_i:
        x=0
        while 1:
            val=p-x*w
            if val%d==0:
                if val>=0 and n-x-val//d>=0:
                    print(x,val//d,n-x-val//d)
                    break
                else:
                    print(-1)
                    break
            x+=1
    else:
        #print("here")
        y=0
        while 1:
            val=p-y*d
            if val%w==0:
                
                if val>=0 and n-y-val//w>=0:
                    print(val//w,y,n-y-val//w)
                    break
                else:
                    print(-1)
                    break
            y+=1



    








BUFSIZE = 8192
class FastIO(BytesIO):
    newlines = 0
 
    def __init__(self, file):
        self._file = file
        self._fd = file.fileno()
        self.writable = "x" in file.mode or "w" in file.mode
        self.write = super(FastIO, self).write if self.writable else None
 
    def _fill(self):
        s = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
        self.seek((self.tell(), self.seek(0,2), super(FastIO, self).write(s))[0])
        return s
 
    def read(self):
        while self._fill(): pass
        return super(FastIO,self).read()
 
    def readline(self):
        while self.newlines == 0:
            s = self._fill(); self.newlines = s.count(b"\n") + (not s)
        self.newlines -= 1
        return super(FastIO, self).readline()
 
    def flush(self):
        if self.writable:
            os.write(self._fd, self.getvalue())
            self.truncate(0), self.seek(0)
 
class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s:self.buffer.write(s.encode('ascii'))
        self.read = lambda:self.buffer.read().decode('ascii')
        self.readline = lambda:self.buffer.readline().decode('ascii')
 
sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip('\r\n')
 
if __name__ == '__main__':
    main()
#threading.Thread(target=main).start()






