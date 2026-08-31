class DSU:
    def __init__(self, n):
        self.parent = [*range(n)]
        self.set_size = [1] * n
        self.roots = set(self.parent)

    def root(self, a):
        while a != self.parent[a]:
            a = self.parent[a]
        return a

    def join(self, a, b):
        a = self.root(a)
        b = self.root(b)

        if self.set_size[a] < self.set_size[b]:
            a, b = b, a

        if a == b:
            return False

        self.roots.remove(b)
        self.set_size[a] += self.set_size[b]
        self.set_size[b] = 0
        self.parent[b] = a

        return True


n = int(input())
roads = []

d = DSU(n)
for _ in range(n - 1):
    i = [*map(int, input().split())]
    if d.join(i[0] - 1, i[1] - 1) is False:
        roads.append(i)

ans = []

while len(d.roots) > 1 and len(roads):
    i = iter(d.roots)
    ans.append((roads[-1][0], roads[-1][1], next(i) + 1, next(i) + 1))
    d.join(ans[-1][2] - 1, ans[-1][3] - 1)
    del roads[-1]

print(len(ans))
for i in ans:
    print(*i)
