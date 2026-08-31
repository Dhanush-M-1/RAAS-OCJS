import sys
x = 150000
sys.setrecursionlimit(x)

def go():
    n = int(input())
    e = {i: set() for i in range(n)}
    for i in range(n - 1):
        a, b = map(lambda s: int(s) - 1, input().split())
        e[a].add(b)
        e[b].add(a)

    parent = [-1 for v in range(n)]
    lev = [-1 for v in range(n)]

    # def dfs(v, level, par):
    #     lev[v] = level
    #     parent[v] = par
    #     for u in e[v]:
    #         if parent[u] == -1:
    #             dfs(u, level + 1, v)
    stack = [0]
    lev[0]=0
    parent[0]=0
    while stack:
        v = stack.pop()
        for u in e[v]:
            if parent[u] == -1:
                lev[u] = lev[v]+1
                parent[u] = v
                stack.append(u)
    # dfs(0, 0, 0)



    levmx = max(lev)
    bindep = levmx.bit_length()
    P = [[-1] * bindep for _ in range(n)]

    for i in range(n):
        P[i][0] = parent[i]

    for j in range(1, bindep):
        for i in range(n):
            if P[i][j - 1] != -1:
                P[i][j] = P[P[i][j - 1]][j - 1]


    def lca(u, v):
        if lev[u] < lev[v]:
            u, v = v, u

        dist = lev[u] - lev[v]
        while dist:
            podn = dist.bit_length() - 1
            u = P[u][podn]
            dist -= (1 << podn)

        if u == v:
            return u

        j = bindep - 1
        while j >= 0:
            if (P[u][j] != -1) and (P[u][j] != P[v][j]):
                u = P[u][j]
                v = P[v][j]
            j -= 1

        return parent[u]


    def dist(a, b):
        return lev[a] + lev[b] - 2 * lev[lca(a, b)]

    ans=[]
    Q = int(input())
    for _ in range(Q):
        x, y, a, b, k = map(int, input().split())
        x, y, a, b = map(lambda aa: aa - 1, [x, y, a, b])
        dab = dist(a, b)
        if dab <= k and (dab - k) % 2 == 0:
            ans.append('YES')
        else:
            # dxy = dist(x, y)
            dax = dist(a, x)
            dby = dist(b, y)
            if dax + 1 + dby <= k and \
                    (k- (dax + 1 + dby))%2==0:
                ans.append ('YES')
            else:
                day = dist(a, y)
                dbx = dist(b, x)
                if dbx + 1 + day <= k and \
                    (k- (dbx + 1 + day))%2==0:
                    ans.append ('YES')
                else:
                    ans.append('NO')
    print('\n'.join(ans))
go()