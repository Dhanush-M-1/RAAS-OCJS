import io
import os

from collections import Counter, defaultdict, deque

MOD = 10 ** 9 + 7


class UnionFind:
    def __init__(self, N):
        # Union find with component size
        # Negative means is a root where value is component size
        # Otherwise is index to parent
        self.p = [-1 for i in range(N)]

    def find(self, i):
        # Find root with path compression
        if self.p[i] >= 0:
            self.p[i] = self.find(self.p[i])
            return self.p[i]
        else:
            return i

    def union(self, i, j):
        # Union by size
        root1 = self.find(j)
        root2 = self.find(i)
        if root1 == root2:
            return
        size1 = -self.p[root1]
        size2 = -self.p[root2]
        if size1 < size2:
            self.p[root1] = root2
            self.p[root2] = -(size1 + size2)
        else:
            self.p[root2] = root1
            self.p[root1] = -(size1 + size2)

    def getComponentSize(self, i):
        return -self.p[self.find(i)]


def solve(N, M, vectors):
    uf = UnionFind(M + 1)
    DUMMY_COMP = M
    ans = []
    for i, v in enumerate(vectors):
        if len(v) == 1:
            (a,) = v
            if uf.find(a) != uf.find(DUMMY_COMP):
                uf.union(a, DUMMY_COMP)
                ans.append(i)
        else:
            assert len(v) == 2
            a, b = v
            if uf.find(a) != uf.find(b):
                uf.union(a, b)
                ans.append(i)
    for i in range(M):
        uf.find(i)

    T = pow(2, uf.getComponentSize(DUMMY_COMP) - 1, MOD)
    T %= MOD
    seen = set()
    for i in range(M):
        comp = uf.find(i)
        if comp != uf.find(DUMMY_COMP) and comp not in seen:
            T *= pow(2, uf.getComponentSize(i) - 1, MOD)
            T %= MOD
            seen.add(comp)
    return str(T) + " " + str(len(ans)) + "\n" + " ".join(str(i + 1) for i in ans)


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    TC = 1  # int(input())
    for tc in range(1, TC + 1):
        (N, M) = [int(x) for x in input().split()]
        vectors = [[int(x) - 1 for x in input().split()][1:] for i in range(N)]
        ans = solve(N, M, vectors)
        print(ans)
