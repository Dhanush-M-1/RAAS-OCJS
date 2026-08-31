class Fenwick:
    def __init__(self, size):
        self.tree = [0] * size
        self.size = size
    def add(self, idx, delta):
        while idx < self.size:
            self.tree[idx] += delta
            idx = (idx + 1) | idx
    def getp(self, right):
        res = 0
        while right != -1:
            res += self.tree[right]
            right = ((right + 1) & right) - 1
        return res
    def get(self, left, right):
        if left > right:
            return 0
        return self.getp(right) - self.getp(left - 1)
n = int(input())
X = list(map(int, input().split()))
V = list(map(int, input().split()))
XV = list(zip(X, V))
XV.sort()
order = list(range(n))
order.sort(key=lambda i: XV[i][1])
ans = 0
for i in range(n):
    ans += XV[n - 1 - i][0] * (n - 1 - 2 * i)
fw = Fenwick(n)
fwcount = Fenwick(n)
for i in order:
    ans -= fw.get(i + 1, n - 1) - fwcount.get(i + 1, n - 1) * XV[i][0]
    fw.add(i, XV[i][0])
    fwcount.add(i, 1)
print(ans)
