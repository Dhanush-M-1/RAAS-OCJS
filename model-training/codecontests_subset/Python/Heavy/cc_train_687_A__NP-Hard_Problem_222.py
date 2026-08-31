import sys


def make_dfs(G, **kwargs):
    col = {i: 0 for i in G}
    vis = {i: False for i in G}

    def dfs(u, color=0):
        if vis[u]:
            return
        s = set([u])
        while len(s) > 0:
            u = s.pop()
            for v in G[u]:
                if not vis[v]:
                    s.add(v)
                    vis[v] = True
                    col[v] = 1-col[u]
                if col[v] == col[u]:
                    raise ValueError

    return dfs, col


def main():
    n, m = map(int, input().split())
    G = {i+1: [] for i in range(n)}
    for i in range(m):
        u, v = map(int, input().split())
        G[u].append(v)
        G[v].append(u)

    dfs, col = make_dfs(G)
    try:
        for i in G:
            dfs(i)
    except ValueError:
        print (-1)
        return

    ans1 = [i for i in G if col[i] == 0]
    ans2 = [i for i in G if col[i] != 0]

    print (len(ans1))
    print (' '.join(map(str, ans1)))
    print (len(ans2))
    print (' '.join(map(str, ans2)))


main()
