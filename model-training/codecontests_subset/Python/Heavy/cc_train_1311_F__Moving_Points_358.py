class Points:
    def __init__(self, x = 0, v = 0):
        self.x, self.v = x, v

class Fenwick_tree:
    def __init__(self, n = 0):
        self.n = n
        self.bit = [0] * (n + 1)

    def update(self, x, value):
        while x <= self.n:
            self.bit[x] += value
            x += x & -x

    def get(self, x):
        sum = 0;
        while x > 0:
            sum += self.bit[x];
            x -= x & -x
        return sum
# Input:
n, x, v = int(input()), list(map(int,input().split())), list(map(int,input().split()))
a = [Points(x[i], v[i]) for i in range(n)]
a.sort(key = lambda value: value.x)
# Compress data:
temp = sorted(set(v))
mp = {v: k for k, v in enumerate(temp, 1)}
# Solve the problem:
cnt = Fenwick_tree(n)
sum = Fenwick_tree(n)
res, i = 0, 0
for i in range(n):
    a[i].v = mp[a[i].v]
    res += a[i].x * cnt.get(a[i].v) - sum.get(a[i].v)
    cnt.update(a[i].v, 1)
    sum.update(a[i].v, a[i].x)
print(res)