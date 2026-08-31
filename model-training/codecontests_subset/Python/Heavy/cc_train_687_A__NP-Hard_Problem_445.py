import sys

def solve():
    n, m = [int(x) for x in input().split()]
    E = {i:[] for i in range(n)}
    for i in range(m):
        u, v = [int(x) - 1 for x in input().split()]
        E[u].append(v)
        E[v].append(u)

    color = [None]*n
    stack = []
    for v in range(n):
        if color[v] is None:
            stack.append((v, True))
            while stack:
                u, col = stack.pop()
                color[u] = col
                for w in E[u]:
                    if color[w] is None:
                        stack.append((w, not col))
                    elif color[w] == col:
                        print(-1)
                        return None
    
    A = list(filter(lambda v: color[v-1], range(1, n+1)))
    B = list(filter(lambda v: not color[v-1], range(1, n+1)))

    if n == 1:
        print(-1)
    elif m == 0:
        print(1)
        print(1)
        print(n-1)
        print(' '.join(map(str, range(2, n+1))))
    else:
        print(len(A))
        print(' '.join(map(str, A)))

        print(len(B))
        print(' '.join(map(str, B)))

solve()

