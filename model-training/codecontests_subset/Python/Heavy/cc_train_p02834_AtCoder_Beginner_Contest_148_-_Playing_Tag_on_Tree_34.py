import queue

n,u,v = map(int, input().split())
u -= 1
v -= 1

path = [[] for i in range(n)]

for i in range(n-1):
    a,b = map(int, input().split())
    a -= 1
    b -= 1
    path[a].append(b)
    path[b].append(a)

t = [10**9]*n
t[u]=0
q = queue.Queue()

q.put(u)

while not q.empty():
    p = q.get()
    for x in path[p]:
        if t[x]>t[p]+1:
            q.put(x)
            t[x]=t[p]+1

a = [10**9]*n
a[v]=0
q = queue.Queue()

q.put(v)

while not q.empty():
    p = q.get()
    for x in path[p]:
        if a[x]>a[p]+1:
            q.put(x)
            a[x]=a[p]+1

c = [a[i] for i in range(n) if a[i]>t[i]]
print(max(c)-1)
