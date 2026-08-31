n, u, v = map(int, input().split())
matrix = [[] for _ in range(n)]
import sys
sys.setrecursionlimit(10**8)
for _ in range(n-1):
    a,b = map(int, input().split())
    matrix[a-1].append(b-1)
    matrix[b-1].append(a-1)

C = [0]*n
D = [0]*n

def dfs(x, pre, cnt, c):
    c[x] = cnt
    cnt += 1
    for a in matrix[x]:
        if a == pre:
            continue
        dfs(a, x, cnt, c)

dfs(v-1, -1, 0, C)
dfs(u-1, -1, 0, D)
ans=0

for i in range(n):
    if C[i] > D[i]:
        ans = max(ans, C[i]-1)
print(ans)