import os
import sys
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
##########################################################
def prime_factors(x):
    s=set()
    n=x
    i=2
    while i*i<=n:
        if n%i==0:
            while n%i==0:
                n//=i
            s.add(i)
        i+=1
    if n>1:
        s.add(n)
    return s
from collections import Counter
# c=sorted((i,int(val))for i,val in enumerate(input().split()))
import heapq
# c=sorted((i,int(val))for i,val in enumerate(input().split()))
# n = int(input())
# ls = list(map(int, input().split()))
# n, k = map(int, input().split())
# n =int(input())
#arr=[(i,x) for i,x in enum]
#arr.sort(key=lambda x:x[0])
#print(arr)
import math
# e=list(map(int, input().split()))
from collections import Counter
#print("\n".join(ls))
#print(os.path.commonprefix(ls[0:2]))
#n=int(input())
from bisect import  bisect_right
#d=sorted(d,key=lambda x:(len(d[x]),-x))  d=dictionary     d={x:set() for x in arr}
#n=int(input())
#n,m,k= map(int, input().split())
import heapq
#for _ in range(int(input())):
#n,k=map(int, input().split())
import sys
input = sys.stdin.buffer.readline
def add(x):

    global ans
    if x>=1 and x<=n and  arr[x] > arr[x - 1] and arr[x] > arr[x + 1] :
        ans+= arr[x]
    elif x>=1 and x<=n and arr[x]<arr[x-1] and arr[x]<arr[x+1]:
        ans-=arr[x]

def erase(x):
    global ans

    if x>=1 and x<=n and arr[x]>arr[x-1] and arr[x]>arr[x+1]:
        ans-=arr[x]
    elif x>=1 and x<=n and arr[x]<arr[x-1] and arr[x]<arr[x+1] :
        ans+=arr[x]

#for _ in range(int(input())):
#ans=0
import math
#n=int(input())
from collections import deque
node=0
def dfs(s,co):
    q=deque([s])
    c[s]=co
    vis[s]=1
    while q:
        node=q.popleft()

        for i in g[node]:
            if vis[i]==0:
                q.append(i)
                vis[i]=1

                c[i]=(c[node]+1)%2
            else:
                if c[i]==c[node]:
                    print(-1)
                    exit()









n,m=map(int, input().split())
g=[[] for i in range(n+2)]
vis=[0]*(n+2)
for i in range(m):
    u,v= map(int, input().split())
    g[u].append(v)
    g[v].append(u)

c=[-1]*(n+2)
for i in range(1,n+1):
    if g[i]==[]:
        continue
    else:
        if vis[i]==0:
            dfs(i,0)

tt=[]
a=[]
for i in range(1,n+1):
    if c[i]==0:
        a.append(i)
    elif c[i]==1:
        tt.append(i)
print(len(a))
print(*a)
print(len(tt))
print(*tt)




