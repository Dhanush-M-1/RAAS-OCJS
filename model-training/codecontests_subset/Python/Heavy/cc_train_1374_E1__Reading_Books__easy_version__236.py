from operator import add


class SegTree():
    def __init__(self, N, e, operator_func=add):
        self.e = e
        self.size = N
        self.node = [self.e] * (2*N)
        self.operator_func = operator_func

    def set_list(self, l):
        for i in range(self.size):
            self.node[i+self.size-1] = l[i]
        for i in range(self.size-1)[::-1]:
            self.node[i] = self.operator_func(self.node[2*i+1], self.node[2*i+2])
    
    def update(self, k, x):
        k += self.size-1
        self.node[k] = x
        while k >= 0:
            k = (k - 1) // 2
            self.node[k] = self.operator_func(self.node[2*k+1], self.node[2*k+2])

    def get(self, l, r):
        x = self.e
        l += self.size
        r += self.size

        while l<r:
            if l&1:
                x = self.operator_func(x, self.node[l-1])
                l += 1
            if r&1:
                r -= 1
                x = self.operator_func(x, self.node[r-1])
            l >>= 1
            r >>= 1
        return x

n, k = map(int, input().split())
l1, l2, l3 = [], [], []
for _ in range(n):
    t, a, b = map(int, input().split())
    if a==0 and b==0:
        continue
    elif a and b:
        l2.append(t)
    elif a:
        l1.append(t)
    else:
        l3.append(t)
l1.sort()
l2.sort()
l3.sort()
s1, s2, s3 = len(l1), len(l2), len(l3)
tree1 = SegTree(s1, 0, add)
tree2 = SegTree(s2, 0, add)
tree3 = SegTree(s3, 0, add)
tree1.set_list(l1)
tree2.set_list(l2)
tree3.set_list(l3)

INF = 10**20
ans = INF

for i in range(k+1):
    if i<=s2 and k-i<=s1 and k-i<=s3:
        p = max(0, k-i)
        v = tree2.get(0, i)+tree1.get(0, p)+tree3.get(0, p)
        ans = min(ans, v)

print(ans if ans!=INF else -1)

