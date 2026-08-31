class Stree:
    def __init__(self, f, n, default, init_data):
        self.ln = 2**(n-1).bit_length()
        self.data = [default] * (self.ln * 2)
        self.f = f
        for i, d in init_data.items():
            self.data[self.ln + i] = d
        for j in range(self.ln - 1, -1, -1):
            self.data[j] = f(self.data[j*2], self.data[j*2+1])

    def update(self, i, a):
        p = self.ln + i
        self.data[p] = a
        while p > 1:
            p = p // 2
            self.data[p] = self.f(self.data[p*2], self.data[p*2+1])

    def get(self, i, j):
        def _get(l, r, p):
            if i <= l and j >= r:
                return self.data[p]
            else:
                m = (l+r)//2
                if j <= m:
                    return _get(l, m, p*2)
                elif i >= m:
                    return _get(m, r, p*2+1)
                else:
                    return self.f(_get(l, m, p*2), _get(m, r, p*2+1))
        return _get(0, self.ln, 1)


def dfs(adj):
    n = len(adj)
    parent = [None] * n
    depth = [-1] * n
    depth[0] = 0
    stack = [(0, adj[0])]
    euler = []
    eulerfirst = [-1] * n

    while stack:
        p, aa = stack.pop()
        if eulerfirst[p] == -1:
            eulerfirst[p] = len(euler)
        euler.append(p)
        for c in aa[::-1]:
            if c != parent[p]:
                parent[c] = p
                depth[c] = depth[p] + 1
                stack.append((p, []))
                stack.append((c, adj[c]))
    return euler, eulerfirst, parent, depth


class Lca:
    # must form a tree
    def __init__(self, adj):
        self.adj = adj
        self.euler, self.eulerfirst, self.parent, self.depth = dfs(adj)

        def f(l, r):
            if self.depth[l] < self.depth[r]:
                return l
            else:
                return r

        self.stree = Stree(f, len(self.euler), 0, dict(enumerate(self.euler)))

    def lca(self, a, b):
        if a == b:
            return a
        fa = self.eulerfirst[a]
        fb = self.eulerfirst[b]
        if fb < fa:
            fa, fb = fb, fa
        return self.stree.get(fa, fb)

    def dist(self, a, b):
        return self.depth[a] + self.depth[b] - 2*self.depth[self.lca(a, b)]


from sys import stdin, gettrace

if not gettrace():
    def input():
        return next(stdin)[:-1]


def main():
    n = int(input())
    adj= [[] for _ in range(n)]
    for _ in range(n-1):
        x, y = map(int, input().split())
        adj[x-1].append(y-1)
        adj[y-1].append(x-1)
    lca = Lca(adj)

    def solve():

        x, y, a, b, k = map(int, input().split())
        x -=1
        y -=1
        a -=1
        b -=1
        dab= lca.dist(a, b)
        if dab <= k and (k - dab)%2 == 0:
            print("YES")
            return
        dxa = lca.dist(x, a)
        dyb = lca.dist(y, b)
        if dxa + dyb + 1 <= k and (k - dxa - dyb -1) % 2 == 0:
            print("YES")
            return
        dya = lca.dist(y, a)
        dxb = lca.dist(x, b)
        if dya + dxb + 1 <= k and (k - dya - dxb -1) % 2 == 0:
            print("YES")
            return
        print("NO")

    q = int(input())
    for _ in range(q):
        solve()


if __name__ == "__main__":
    main()