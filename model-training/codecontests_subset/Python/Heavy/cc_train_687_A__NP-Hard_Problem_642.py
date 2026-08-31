import sys
input=sys.stdin.buffer.readline
n, m = list(map(int, input().split()))
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


class Graph:

    def __init__(self, V):
        self.V = V
        self.adj = [[] for i in range(V)]

    @bootstrap
    def DFSUtil(self, v, visited,color,black,white):

        visited[v] = True
        temp=0



        for i in self.adj[v]:
            if visited[i] == False:
                color[i] = 1 - color[v]
                if color[i]==0:
                    black.append(i+1)
                else:
                    white.append(i+1)
                temp = yield self.DFSUtil(i, visited,color,black,white)


                if temp==-1:
                    yield -1
            else:
                if color[i]==color[v]:
                    yield -1
        yield temp

    def addEdge(self, v, w):
        self.adj[v].append(w)
        self.adj[w].append(v)

G=Graph(n)

for i in range(m):
    u,v=list(map(int,input().split()))
    G.addEdge(u-1,v-1)
visited=[False for _ in range(n)]
start=0
flag=0
color=[-1 for i in range(n)]

black=[]
white=[]
# white.append(1)
for i in range(0,len(visited)):
    if visited[i]==True:
        continue
    color[i] = 1
    white.append(i + 1)
    ans=G.DFSUtil(i,visited,color,black,white)

    if ans==-1:
        flag=1
        break

if flag==1:
    print(-1)
else:
    k=sum(color)
    print(k)
    print(*white)
    print(n-k)
    print(*black)