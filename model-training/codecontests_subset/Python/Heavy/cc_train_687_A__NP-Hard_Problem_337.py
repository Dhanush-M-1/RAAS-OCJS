import io,os,sys,math
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
from types import GeneratorType
def bootstrap(f, stack=[]):
    def wrappedfunc(*args, **kwargs):
        if stack:
            return f(*args, **kwargs)
        else:
            to = f(*args, **kwargs)
            while True:
                if type(to) is GeneratorType:
                    stack.append(to)
                    to = next(to)
                else:
                    stack.pop()
                    if not stack:
                        break
                    to = stack[-1].send(to)
            return to
    return wrappedfunc
"********************************************************************"
n,m=map(int,input().split())
adj=[[] for i in range(n+1)]
edges=[]
for i in range(m):
    s,e=map(int,input().split())
    adj[s].append(e)
    adj[e].append(s)
    edges.append((s,e))
visited=[3]*(n+1)
@bootstrap
def dfs(node,old):
    if visited[node] != 3:
        yield
    new=(old+1)%2
    visited[node]=new
    for i in adj[node]:
        yield dfs(i,new)
    yield
for i in range(1,n+1):
    if visited[i] == 3:
        dfs(i,0)
f=True

for s,e in edges:
    if visited[s] == visited[e]:
        print(-1)
        f=False
        break
if f:
    ans1=[]
    ans2=[]
    for i in range(1,n+1):
        if visited[i] == 0:
            ans1.append(i)
        else:
            ans2.append(i)
    print(len(ans1))
    print(*ans1)
    print(len(ans2))
    print(*ans2)
