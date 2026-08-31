class BIT():
    def __init__(self, array):
        self.n = len(array)
        self.bit = [0] + array
        self.build()

    def build(self):
        for i in range(1, self.n):
            if i + (i & -i) > self.n:
                continue
            self.bit[i + (i & -i)] += self.bit[i]

    def _sum(self, i):
        s = 0
        while i > 0:
            s += self.bit[i]
            i -= i & -i
        return s

    def add(self, i, val):
        i += 1
        while i <= self.n:
            self.bit[i] += val
            i += i & -i

    def get_sum(self, l, r):
        return self._sum(r) - self._sum(l)


from operator import itemgetter
import sys
input = sys.stdin.readline

n = int(input())
x = list(map(int, input().split()))
v = list(map(int, input().split()))

sorted_x = sorted(x)
bit = BIT(sorted_x)
bit_ind = BIT([1] * n)
to_ind = {v: i for i, v in enumerate(sorted_x)}

info = [None] * n
for i in range(n):
    info[i] = (v[i] + 10**18, x[i])
info = sorted(info, key=itemgetter(1), reverse=True)
info = sorted(info, key=itemgetter(0), reverse=True)

ans = 0
for i in range(n):
    _, pos = info[i]
    ind = to_ind[pos]
    sum_ = bit.get_sum(0, ind)
    num = bit_ind.get_sum(0, ind)
    ans +=  num * pos -  sum_
    bit.add(ind, -pos)
    bit_ind.add(ind, -1)
print(ans)
