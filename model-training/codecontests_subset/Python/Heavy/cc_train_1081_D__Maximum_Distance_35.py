import sys


class UnionFind():
    def __init__(self, n, List):
        self.n = n
        self.parents = [-1] * (n+1)
        self.Parents = [-1] * (n+1)
        for v in List:
            self.Parents[v] -= 1

    def find(self, x):
        if self.parents[x] < 0:
            return x
        else:
            self.parents[x] = self.Parents[x] = self.find(self.parents[x])
            return self.parents[x]

    def union(self, x, y):
        x = self.find(x)
        y = self.find(y)

        if x == y:
            return

        if self.parents[x] > self.parents[y]:
            x, y = y, x

        self.parents[x] += self.parents[y]
        self.Parents[x] += self.Parents[y]
        self.parents[y] = x
        self.Parents[y] = x

    def specialcnt(self, x):
        return (-self.Parents[self.find(x)]) - (-self.parents[self.find(x)])

    def size(self, x):
        return -self.parents[self.find(x)]

    def same(self, x, y):
        return self.find(x) == self.find(y)

    def members(self, x):
        root = self.find(x)
        return [i for i in range(self.n + 1) if self.find(i) == root]

    def roots(self):
        return [i for i, x in enumerate(self.parents) if x < 0]


def input():
    return sys.stdin.readline()


def main():
    n, m, k = map(int, input().split())
    specials = list(map(int, input().split()))
    que = []
    onenode = specials[0]
    U = UnionFind(n + 10, specials)
    for i in range(m):
        u, v, w = map(int, input().split())
        que.append((w, u, v))
    que.sort()
    for w,u,v in que:
        U.union(u, v)
        if U.specialcnt(onenode) == k:
            print(*([w]*k))
            return
    return


if __name__ == "__main__":
    main()
