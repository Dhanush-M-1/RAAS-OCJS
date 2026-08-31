# Link: http://codeforces.com/contest/25/problem/D

import os
import sys
import math
import itertools
from io import BytesIO, IOBase

#<fast I/O>
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
#</fast I/O>

#<template>
mod=(10**9)+7
pi=3.14159265358979323846264338327950

def i1():   #int(input())
    return int(sys.stdin.readline())

def sf():   #input()
    return sys.stdin.readline()

def mi():   #map(int(input()))
    return map(int,sys.stdin.readline().split())

def arr():  #list(map(int,input().split()))
    return list(map(int,sys.stdin.readline().split()))

def pf(ans): #print(x)
    return sys.stdout.write(str(ans)+"\n")

def gcd(a,b):
    if a==0:
        return b
    elif b==0:
        return a
    if a>b:
        return gcd(a%b,b)
    else:
        return gcd(a,b%a)

def lcm(a,b):
    return (a*b)//gcd(a,b)
#</template>

#<testcases>
#sys.stdin=open('input.txt','r')
#sys.stdout=open('output.txt','w')
#</testcases>



#<solve>
def solve():
    n = int(input())
    parent = [i for i in range(n+1)]
    rank = [0] * (n+1)

    # Keep track of the roads that needs to be removed
    close = []

    # Keep track of the roads that needs to be built
    build = []

    # Find the representative of the set that has vertex as one of it's descendents
    # using path compression
    def find(vertex):
        if vertex != parent[vertex]:
            parent[vertex] = find(parent[vertex])
        return parent[vertex]

    # Using union by rank
    def union(x, y):
        parent_x = find(x)
        parent_y = find(y)
        if rank[parent_x] < rank[parent_y]:
            parent[parent_x] = parent_y
        elif rank[parent_y] < rank[parent_x]:
            parent[parent_y] = parent_x
        else:
            parent[parent_y] = parent_x
            rank[parent_x] += 1

    def roads():
        for i in range(n-1):
            u, v = map(int, input().split())

            # If u and v have same parent or they are in the same set then this road needs 
            # to be removed.
            if find(u) == find(v):
                close.append([u, v])
            else:
                # union u, v
                union(u, v)
        
        for i in range(2, n+1):
            # if i and 1 are not in the same set then union them and built the road 
            # between these nodes
            if find(i) != find(1):
                union(i, 1)
                build.append([1, i])
    roads()
    print(len(build))
    for i in range(len(close)):
        print(close[i][0], close[i][1], build[i][0], build[i][1])
#</solve>

#<solution>
#tc=i1()
#for t in range (tc):
solve()
#<solution>