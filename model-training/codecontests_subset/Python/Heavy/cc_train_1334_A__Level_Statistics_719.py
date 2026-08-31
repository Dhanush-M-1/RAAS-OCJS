import os
import heapq
import sys,threading
import math as mt
import operator
from copy import copy
from collections import defaultdict,deque
from io import BytesIO, IOBase

sys.setrecursionlimit(10 ** 5)
#threading.stack_size(2**27)


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


"""def pw(a,b):
    result=1
    while(b>0):
        if(b%2==1): result*=a
        a*=a
        b//=2
    return result"""


def inpt():
    return [int(k) for k in input().split()]

def main():
    for _ in range(int(input())):
        # n,x=inpt()
        # ar=inpt()
        # ar.sort(reverse=True)
        # ans=0
        # sm=0
        # for i in range(n):
        #     sm+=ar[i]
        #     val=sm/(i+1)
        #     if(val>=x):
        #         ans=i+1
        # print(ans)
        n=int(input())
        play,clear=-1,-1
        ok=True
        for _ in range(n):
            a,b=inpt()
            if(a<play or b>a or b<clear):
                ok=False
            dif1=a-play
            dif2=b-clear
            if(dif2>dif1):
                ok=False
            play,clear=a,b
        if(ok):
            print('YES')
        else:
            print('NO')










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
    #threading.Thread(target=main).start()
