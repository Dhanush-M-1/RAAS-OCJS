from sys import stdin

def input():
    return next(stdin)[:-1]


class DisjointUnionSet:

    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find_set(self, v):
        if v == self.parent[v]:
            return v
        self.parent[v] = self.find_set(self.parent[v])
        return self.parent[v]

    def union_sets(self, a, b):
        a = self.find_set(a)
        b = self.find_set(b)
        if a != b:
            if self.rank[a] < self.rank[b]:
                a, b = b, a
            self.parent[b] = a
            if self.rank[a] == self.rank[b]:
                self.rank[a] += 1

def main():
    def solve():
        n, m, a, b = map(int, input().split())
        dusa = DisjointUnionSet(n)
        dusb = DisjointUnionSet(n)
        for _ in range(m):
            u, v = map(int, input().split())
            if u != a and v != a:
                dusa.union_sets(u-1, v-1)
            if u != b and v != b:
                dusb.union_sets(u-1,v-1)
        pa = dusb.find_set(a-1)
        pb = dusa.find_set(b-1)
        ac = 0
        bc = 0
        for i in range(n):
            if i == a-1 or i == b-1:
                continue
            if dusa.find_set(i) != pb:
                ac+=1
            if dusb.find_set(i) != pa:
                bc +=1
        print(ac*bc)


    q = int(input())
    for _ in range(q):
        solve()


if __name__ == "__main__":
    main()