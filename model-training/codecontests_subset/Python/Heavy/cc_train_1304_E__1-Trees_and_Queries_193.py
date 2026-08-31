"""
NTC here
"""
# NOT MY CODE
# testing nikeshthapa255's submission
#https://codeforces.com/contest/1304/submission/71634040
import sys
# reader = (s.rstrip() for s in sys.stdin)
# input = reader.__next__
inp = sys.stdin.buffer.readline
 
 
def input(): return inp().strip()
 
 
out = []
# flush = sys.stdout.flush
# import threading
# sys.setrecursionlimit(10**7)
# threading.stack_size(2**25)
 
 
def iin(): return int(input())
 
 
def lin(): return list(map(int, input().split()))
 
 
# range = xrange
# input = raw_input
 
 
INF = 10**5+7
n = iin()
adj = [[] for i in range(n+1)]
for _ in range(n-1):
    i, j = lin()
    adj[i].append(j)
    adj[j].append(i)
 
# LCA - lowest common ancestor
 
 
def dfs(adj, start=1):
    n = len(adj)
    visited = [False]*n
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
        visited[v] = True
        if parent[v] != -1:
            srt.append(parent[v])
        for u in adj[v]:
            if not visited[u]:
                parent[u] = v
                height[u] = height[v]+1
                srt.append(u)
 
    return first, euler, height
 
 
# segment tree
first, euler, height = dfs(adj)
# print(first, euler, height)
euler = [height[i] for i in euler]
 
 
class RangeQuery:
    def __init__(self, data, func=min):
        self.func = func
        self._data = _data = [list(data)]
        i, n = 1, len(_data[0])
        while 2 * i <= n:
            prev = _data[-1]
            _data.append([func(prev[j], prev[j + i]) for j in range(n - 2 * i + 1)])
            i <<= 1
 
    def query(self, begin, end):
        end += 1
        depth = (end - begin).bit_length() - 1
        tmp = self._data[depth]
        return self.func(tmp[begin], tmp[end - (1 << depth)]) 
 
sa = RangeQuery(euler)
 
 
def check(i, j):
    l, r = first[i], first[j]
    if l > r:
        l, r = r, l
    h = sa.query(l, r)
    #print("CHK", l, r, h, i, j)
    return height[i] + height[j] - 2*h
 
 
# print(euler)
q = iin()
while q:
    q -= 1
    x, y, a, b, k = lin()
    ans1 = [check(a, b), check(a, x)+1+check(y, b),
            check(a, y)+1+check(x, b)]
    for i in ans1:
        if ((k-i) >= 0 and (k-i) % 2 == 0):
            out.append('YES')
            break
    else:
        out.append('NO')
    # print(ans, ans1)
    # out.append('YES' if True in ans else 'NO')
print('\n'.join(out))
 
 
# main()
# threading.Thread(target=main).start()