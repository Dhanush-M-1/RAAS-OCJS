N,U,V = map(int,input().split())
U,V = U-1, V-1

adj = [list() for _ in range(N)]

for _ in range(N-1):
    a,b = map(int,input().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)



dist_u = [None]*N
dist_u[U] = 0
stack = [U]

while stack:
    x = stack.pop()
    d = dist_u[x]+1
    for y in adj[x]:
        if dist_u[y] is None:
            dist_u[y] = d
            stack.append(y)


dist_v = [None]*N
dist_v[V] = 0
stack = [V]

while stack:
    x = stack.pop()
    d = dist_v[x]+1
    for y in adj[x]:
        if dist_v[y] is None:
            dist_v[y] = d
            stack.append(y)

n = max(b for a,b in zip(dist_u, dist_v) if a < b)
m = min((b for a,b in zip(dist_u, dist_v) if a <= b), default=n)

print(max(n,m)-1)