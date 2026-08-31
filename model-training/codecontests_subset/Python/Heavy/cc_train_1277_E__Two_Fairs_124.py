import sys
from collections import defaultdict

# inf = open('input.txt', 'r')
# reader = (map(int, line.split()) for line in inf)
reader = (map(int, s.split()) for s in sys.stdin)   

t, = next(reader)
for _ in range(t):
    n, m, a, b = next(reader) # v(G), e(G), a, b
    a -= 1
    b -= 1
    
    g = defaultdict(list)
    for i in range(m):
        v, to = next(reader)
        v -= 1
        to -= 1
        g[v].append(to)
        g[to].append(v)

    def dfs(s, comp):
        stack = [s]
        while stack:
            v = stack.pop()
            if not visited[v]:
                visited[v] = True
                comp.add(v)
                stack.extend(g[v])

    visited = [False] * n
    visited[b] = True
    compA = set()
    dfs(s=a, comp=compA)
    compA -= {a}
    
    visited = [False] * n
    visited[a] = True
    compB = set()
    dfs(s=b, comp=compB)
    compB -= {b}
    
    ans = len(compA - compB) * len(compB - compA)
    print(ans)

# inf.close()