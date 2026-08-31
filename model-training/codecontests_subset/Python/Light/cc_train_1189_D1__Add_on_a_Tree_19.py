n = int(input())
g = [[] for i in range(n+1)]
d = [0]*100001
for i in range(n-1):
    u, v = [int(i) for i in input().split()]
    g[u].append(v)
    g[v].append(u)
    d[u] += 1
    d[v] += 1
for i in d:
    if i == 2:
        print("NO")
        break
else:
    print("YES")
