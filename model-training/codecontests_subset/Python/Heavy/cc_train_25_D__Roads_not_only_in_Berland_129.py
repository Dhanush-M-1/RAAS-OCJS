def find(u):
    if parent[u] == u:
        return u

    parent[u] = find(parent[u])
    return parent[u]


def union(a, b):
    u = parent[a]
    v = parent[b]

    if size[u] > size[v]:
        parent[v] = u
        size[u] += size[v]

    else:
        parent[u] = v
        size[v] += size[u]



n=int(input())
parent=[i for i in range(n+1)]
size = [1 for i in range(n + 1)]

torm=[]
for j in range(n-1):
    u,v=map(int,input().split())
    if find(u)!=find(v):
        union(u,v)
    else:
        torm.append([u,v])

toadd=[]
for i in range(1,n+1):
    if find(1)!=find(i):
        union(1,i)
        toadd.append([1,i])

ans=[]
for j in range(len(toadd)):
    ans.append(torm[j]+toadd[j])

print(len(ans))
for j in ans:
    print(*j)






