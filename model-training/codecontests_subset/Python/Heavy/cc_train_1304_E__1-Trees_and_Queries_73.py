from sys import stdin,stderr
def rl():
    return [int(w) for w in stdin.readline().split()]

from collections import namedtuple

Path = namedtuple('Path', 'length midlength middle left right')

n, = rl()
adj = [[] for _ in range(n+1)]
paths = [None for _ in range(n+1)]
for _ in range(n-1):
    u,v = rl()
    adj[u].append(v)
    adj[v].append(u)

def append(path, x):
    if not path:
        return Path(1, 1, x, None, None)
    l = path.length + 1
    if l >= 2 * path.midlength:
        return Path(l, path.midlength * 2, x, path, None)
    else:
        return Path(l, path.midlength, path.middle, path.left, append(path.right, x))

queue = [(1,0)]
for i in range(n):
    v, parent = queue[i]
    paths[v] = append(paths[parent], v)
    for u in adj[v]:
        if u != parent:
            queue.append((u,v))

def gcp(x, y):
    if not x or not y:
        return 0
    while x.midlength > y.midlength:
        x = x.left
    while y.midlength > x.midlength:
        y = y.left
    if x.middle == y.middle:
        return x.midlength + gcp(x.right, y.right)
    else:
        return gcp(x.left, y.left)

def dist(x, y):
    px = paths[x]
    py = paths[y]
    return px.length + py.length - 2 * gcp(px, py)

q, = rl()
for _ in range(q):
    x,y,a,b,k = rl()
    ds = [
        dist(a,b),
        dist(a,x) + 1 + dist(y,b),
        dist(a,y) + 1 + dist(x,b),
    ]
    for d in ds:
        if k >= d and (k - d) % 2 == 0:
            print("YES")
            break
    else:
        print("NO")
