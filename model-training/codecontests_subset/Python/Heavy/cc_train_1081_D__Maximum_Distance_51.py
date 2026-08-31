import heapq
import os,io
input=io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
class UnionFind():
    def __init__(self, n):
        self.n = n
        self.parents = [-1] * n

    def find(self, x):
        if self.parents[x] < 0:
            return x
        else:
            self.parents[x] = self.find(self.parents[x])
            return self.parents[x]

    def union(self, x, y):
        x = self.find(x)
        y = self.find(y)

        if x == y:
            return

        if self.parents[x] > self.parents[y]:
            x, y = y, x

        self.parents[x] += self.parents[y]
        self.parents[y] = x

    def size(self, x):
        return -self.parents[self.find(x)]

    def same(self, x, y):
        return self.find(x) == self.find(y)

    def members(self, x):
        root = self.find(x)
        return [i for i in range(self.n) if self.find(i) == root]

    def roots(self):
        return [i for i, x in enumerate(self.parents) if x < 0]

    def group_count(self):
        return len(self.roots())

    def all_group_members(self):
        return {r: self.members(r) for r in self.roots()}

    def __str__(self):
        return '\n'.join('{}: {}'.format(r, self.members(r)) for r in self.roots())

n,m,k=map(int,input().split())
x=list(map(int,input().split()))
graph=[]
for i in range(m):
    u,v,w=map(int,input().split())
    graph.append(u)
    graph.append(v)
    graph.append(w)
l=0
r=10**9+1
def is_ok(arg):
    uf=UnionFind(n)
    for i in range(m):
        if graph[i*3+2]>arg:
            continue
        uf.union(graph[i*3+0]-1,graph[i*3+1]-1)
    flag=1
    for i in range(k-1):
        if not uf.same(x[i]-1,x[i+1]-1):
            flag=0
            break
    return flag

def meguru_bisect(ng, ok):
    '''
    初期値のng,okを受け取り,is_okを満たす最小(最大)のokを返す
    まずis_okを定義すべし
    ng ok は  とり得る最小の値-1 とり得る最大の値+1
    最大最小が逆の場合はよしなにひっくり返す
    '''
    while (abs(ok - ng) > 1):
        mid = (ok + ng) // 2
        if is_ok(mid):
            ok = mid
        else:
            ng = mid
    return ok
p=str(meguru_bisect(0,10**9+1))
print(' '.join([p]*k))