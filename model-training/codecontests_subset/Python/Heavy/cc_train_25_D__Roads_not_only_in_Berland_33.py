#dahao

C = 0
n = int(input())
B = [0 for _ in range(n + 1)]
p = [0 for _ in range(n + 1)]
CC = [0 for _ in range(n + 1)]
a = [[] for _ in range(n + 1)]
VV = [] 
V = []
for i in range(n - 1):
    x, y = map(int, input().split())
    a[x].append(y)
    a[y].append(x)
    V.append([x, y])
def anc(u):
    if (p[u] == u): return u
    else: 
        p[u] = anc(p[u])
        return p[u]
def join(u, v): 
    p[anc(u)] = anc(v)
def DFS(u):
    B[u] = C
    for v in a[u]:
        if (B[v] == 0):
            DFS(v)
for i in range(1, n + 1): p[i] = i
for it in V:
    if (anc(it[0]) == anc(it[1])):
        VV.append(it)
    else:
        join(it[0], it[1])
        
for i in range(1, n + 1):
    if (B[i] == 0):
        C += 1
        DFS(i)
for i in range(1, n + 1): CC[B[i]] = i
it = 0
print(C - 1)
for i in range(C - 1):
    print(VV[i][0], ' ', VV[i][1], ' ', CC[i + 1], ' ', CC[i + 2])