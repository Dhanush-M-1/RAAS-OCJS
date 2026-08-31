import sys

n = int(sys.stdin.readline().strip())
d = [0] * n

for i in range (0, n - 1):
    u, v = sys.stdin.readline().strip().split()
    u, v = int(u) - 1, int(v) - 1
    d[u] = d[u] + 1
    d[v] = d[v] + 1

if 2 in d:
    print("NO")
else:
    print("YES")