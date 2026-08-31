import sys
input = iter(sys.stdin.read().splitlines()).__next__


class UnionFind:  # based on submission 102831279
    def __init__(self, n):
        """ elements are 0, 1, 2, ..., n-1 """
        self.parent = list(range(n))
    
    def find(self, x):
        found = x
        while self.parent[found] != found:
            found = self.parent[found]
        while x != found:
            y = self.parent[x]
            self.parent[x] = found
            x = y
        return found
    
    def union(self, x, y):
        self.parent[self.find(x)] = self.find(y)


n, m = map(int, input().split())
S_prime = []
# redundant (linearly dependent) vectors would be part of cycle
uf = UnionFind(m+1)
for index in range(1, n+1):
    # one-hot vectors become (x_1, m)
    vector_description = [int(i)-1 for i in input().split()] + [m]
    u, v = vector_description[1:3]
    if uf.find(u) == uf.find(v):
        continue
    S_prime.append(index)
    uf.union(u, v)

# 2**|S'| different sums among |S'| linearly independent vectors
T_size = pow(2, len(S_prime), 10**9+7)
print(T_size, len(S_prime))
# print(S_prime)
print(*sorted(S_prime))