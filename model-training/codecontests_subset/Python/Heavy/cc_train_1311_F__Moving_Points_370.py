import bisect

class Bit :
    def __init__(self, n) :
        self.bit = [0 for i in range(0, n)]

    def add(self, pos, x) :
        while pos < len(self.bit) :
            self.bit[pos] += x
            pos = pos | (pos + 1)

    def query(self, pos) :
        res = 0
        while pos > 0 :
            res += self.bit[pos - 1];
            pos = pos & (pos - 1)
        return res

n = int(input())
x = [int(i) for i in input().split()]
v = [int(i) for i in input().split()]

r = [i for i in range(n)]
r.sort(key = lambda i : x[i])

unique = sorted(list(set(v)))

tree1, tree2 = Bit(len(unique)), Bit(len(unique))

ans = 0
for i in r :
    ii = bisect.bisect_left(unique, v[i])
    count = tree1.query(ii + 1)
    dsum = tree2.query(ii + 1)
    ans += count * x[i] - dsum
    tree1.add(ii, 1)
    tree2.add(ii, x[i])

print(ans)
