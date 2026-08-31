# NOT MY CODE
# testing nikeshthapa255's submission
#https://codeforces.com/contest/1304/submission/71634040
import sys, os

inp = [int(x) for x in sys.stdin.buffer.read().split()]; ii = 0
out = []
 
INF = 10**5+7
n = inp[ii]; ii += 1
adj = [[] for i in range(n+1)]
for _ in range(n-1):
    i, j = inp[ii], inp[ii + 1]; ii += 2
    adj[i].append(j)
    adj[j].append(i)
 
def dfs(adj, start=1):
    n = len(adj)
    visited = [0]*n
    first = [-1]*n
    euler = []
    height = [-1]*n
    srt = [start]
    height[start] = 1
    parent = [-1]*n
    while srt:
        v = srt.pop()
        if visited[v]:
            euler.append(v)
            continue
        
        first[v] = len(euler)
        euler.append(v)
        visited[v] = 1
        if parent[v] != -1:
            srt.append(parent[v])
        for u in adj[v]:
            if not visited[u]:
                parent[u] = v
                height[u] = height[v]+1
                srt.append(u)
 
    return first, euler, height
 
 
first, euler, height = dfs(adj)
euler = [height[i] for i in euler]
 
 
class Sparse_Table():
    def __init__(self, arr):
        self.arr = arr
        self.n = len(arr)
        self.logfn = lambda x: x.bit_length() - 1
        self.table = self.build()
 
    def build(self):
 
        n = self.n
        sz = int(self.logfn(n))+1
        st = [[INF for i in range(n)] for j in range(sz)]
        st[0] = list(self.arr)
        for i in range(1, sz):
            step = 1 << (i-1)
            sti = st[i]
            stim1 = st[i-1]
            for j in range(n-step*2+1):
                sti[j] = min(stim1[j+step], stim1[j])
        return st
 
    def query(self, begin, end):
        end += 1
        depth = (end - begin).bit_length() - 1
        return min(self.table[depth][begin], self.table[depth][end - (1 << depth)])
 
 
sa = Sparse_Table(euler)
 
 
def check(i, j):
    l, r = first[i], first[j]
    if l > r:
        l, r = r, l
    h = sa.query(l, r)
    return height[i] + height[j] - 2*h
 
 
q = inp[ii]; ii += 1
while q:
    q -= 1
    x, y, a, b, k = inp[ii: ii + 5]; ii += 5
    ans1 = [check(a, b), check(a, x)+1+check(y, b),
            check(a, y)+1+check(x, b)]
    for i in ans1:
        if ((k-i) >= 0 and (k-i) % 2 == 0):
            out.append(b'YES')
            break
    else:
        out.append(b'NO')
os.write(1, b'\n'.join(out))
