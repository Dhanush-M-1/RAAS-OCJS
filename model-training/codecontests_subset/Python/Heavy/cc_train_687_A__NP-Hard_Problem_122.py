"""
Author    : raj1307 - Raj Singh
Institute : Jalpaiguri Government Engineering College
Date      : 6.05.19
"""
from __future__ import division, print_function
import itertools,os,sys,threading
from collections import deque, Counter, OrderedDict,defaultdict
#from heapq import nsmallest, nlargest, heapify, #heappop ,heappush, heapreplace
#from math import ceil,floor,log,sqrt,factorial,pow,pi
#from bisect import bisect_left,bisect_right
#from decimal import *,threading

"""from io import BytesIO, IOBase

if sys.version_info[0] < 3:
    from __builtin__ import xrange as range
    from future_builtins import ascii, filter, hex, map, oct, zip
else:
    from builtins import str as __str__
    str = lambda x=b'': x if type(x) is bytes else __str__(x).encode()

BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._buffer = BytesIO()
        self._fd = file.fileno()
        self._writable = 'x' in file.mode or 'r' not in file.mode
        self.write = self._buffer.write if self._writable else None

    def read(self):
        return self._buffer.read() if self._buffer.tell() else os.read(self._fd, os.fstat(self._fd).st_size)

    def readline(self):
        while self.newlines == 0:
            b, ptr = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE)), self._buffer.tell()
            self._buffer.seek(0, 2), self._buffer.write(b), self._buffer.seek(ptr)
            self.newlines += b.count(b'\n') + (not b)
        self.newlines -= 1
        return self._buffer.readline()

    def flush(self):
        if self._writable:
            os.write(self._fd, self._buffer.getvalue())
            self._buffer.truncate(0), self._buffer.seek(0)


sys.stdin, sys.stdout = FastIO(sys.stdin), FastIO(sys.stdout)
input = lambda: sys.stdin.readline().rstrip(b'\r\n')


def print(*args, **kwargs):
    sep, file = kwargs.pop('sep', b' '), kwargs.pop('file', sys.stdout)
    at_start = True
    for x in args:
        if not at_start:
            file.write(sep)
        file.write(str(x))
        at_start = False
    file.write(kwargs.pop('end', b'\n'))
    if kwargs.pop('flush', False):
        file.flush()

"""



def ii(): return int(input())
def si(): return str(input())
def mi():return map(int,input().strip().split(" "))
def li():return list(mi())

abc='abcdefghijklmnopqrstuvwxyz'
abd={'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5, 'g': 6, 'h': 7, 'i': 8, 'j': 9, 'k': 10, 'l': 11, 'm': 12, 'n': 13, 'o': 14, 'p': 15, 'q': 16, 'r': 17, 's': 18, 't': 19, 'u': 20, 'v': 21, 'w': 22, 'x': 23, 'y': 24, 'z': 25}
mod=1000000007
dx,dy=[-1,1,0,0],[0,0,1,-1]
def getKey(item): return item[0] 
def sort2(l):return sorted(l, key=getKey)
def d2(n,m,num):return [[num for x in range(m)] for y in range(n)]
def isPowerOfTwo (x): return (x and (not(x & (x - 1))) )
def decimalToBinary(n): return bin(n).replace("0b","")
def ntl(n):return [int(i) for i in str(n)]
def powerMod(x,y,p):
    res = 1
    x %= p
    while y > 0:
        if y&1:
            res = (res*x)%p
        y = y>>1
        x = (x*x)%p1
    return res
def gcd(x, y):
    while y:
        x, y = y, x % y
    return x

# For getting input from input.txt file 
#sys.stdin = open('input.txt', 'r')  
  
# Printing the Output to output.txt file 
#sys.stdout = open('output.txt', 'w') 

graph=defaultdict(list)
visited=[0]*1000000
col=[-1]*1000000
def dfs(v,c): 
    
    if visited[v]:
        if col[v]!=c:
            print('-1')
            exit()
        return
    col[v]=c
    visited[v]=1
    for i in graph[v]:
        dfs(i,c^1)



def main():
    
    n,m=mi()
    for i in range(m):
        x,y=mi()
        graph[x].append(y)
        graph[y].append(x)
    
    
    for i in range(1,n+1):
        
        if col[i]==-1:
            dfs(i,1)
    
        
        
        
        
        
    
    a=[]
    b=[]
    
    for i in range(1,n+1):
        if col[i]==0:
            a.append(i)
        elif col[i]==1:
            b.append(i)
            
    print(len(a))
    print(*a)
    print(len(b))
    print(*b)
        
    
       

if __name__ == "__main__":
    #main()
    sys.setrecursionlimit(100000000)
    threading.stack_size(20480000)
    thread = threading.Thread(target=main)
    thread.start()