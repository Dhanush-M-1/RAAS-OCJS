"""
#If FastIO not needed, use this and don't forget to strip
#import sys, math
#input = sys.stdin.readline
"""

import os
import sys
from io import BytesIO, IOBase
import heapq as h 
from bisect import bisect_left, bisect_right
import time

from types import GeneratorType
BUFSIZE = 8192

class FastIO(IOBase):
    newlines = 0
 
    def __init__(self, file):
        import os
        self.os = os
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None
 
    def read(self):
        while True:
            b = self.os.read(self._fd, max(self.os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()
 
    def readline(self):
        while self.newlines == 0:
            b = self.os.read(self._fd, max(self.os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()
 
    def flush(self):
        if self.writable:
            self.os.write(self._fd, self.buffer.getvalue())
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

from collections import defaultdict as dd, deque as dq, Counter as dc
import math, string

start_time = time.time()

def getInts():
    return [int(s) for s in input().split()]

def getInt():
    return int(input())

def getStrs():
    return [s for s in input().split()]

def getStr():
    return input()

def listStr():
    return list(input())

def getMat(n):
    return [getInts() for _ in range(n)]

def isInt(s):
    return '0' <= s[0] <= '9'

MOD = 998244353 

"""

"""

def solve():
    N = getInt()
    graph = dd(set)
    for _ in range(N-1):
        A, B = getInts()
        graph[A].add(B)
        graph[B].add(A)
    nodes = set(range(1,N+1))
    to_connect = []
    to_remove = set()
    def bfs(node):
        to_connect.append(node)
        queue = dq([(node,0)])
        visited.add(node)
        nodes.remove(node)
        while queue:
            node, parent = queue.popleft()
            for neigh in graph[node]:
                if neigh in visited and neigh != parent:
                    x,y = min(node,neigh), max(node,neigh)
                    to_remove.add((x,y))
                elif neigh not in visited:
                    visited.add(neigh)
                    nodes.remove(neigh)
                    queue.append((neigh,node))
    while nodes:
        visited = set()
        node = next(iter(nodes))
        bfs(node)
    to_remove = list(to_remove)
    #print(to_remove,to_connect)
    assert len(to_remove) == len(to_connect)-1
    print(len(to_remove))
    while to_remove:
        i,j = to_remove.pop()
        v = to_connect.pop()
        u = to_connect[-1]
        print(i,j,u,v)
    assert len(to_connect) == 1
    return

#for _ in range(getInt()):
    #print(solve())
solve()

#print(time.time()-start_time)á