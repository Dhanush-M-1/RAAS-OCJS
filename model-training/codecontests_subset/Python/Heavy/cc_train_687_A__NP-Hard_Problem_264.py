from collections import deque

__author__ = 'aste'


def main():
    n, m = [int(x) for x in input().split()]

    color = [0]*n
    graph = [[] for i in range(0, n)]
    for i in range(0, m):
        u, v = [int(x) - 1 for x in input().split()]
        graph[u].append(v)
        graph[v].append(u)

    # bipartite
    res = True
    for i in range(0, n):
        if color[i] != 0:
            continue
        q = deque()
        color[i] = 1
        q.append(i)
        while q:
            v = q.popleft()
            for a in graph[v]:
                if color[a] == 0:
                    color[a] = -color[v]
                    q.append(a)
                elif color[a] != -color[v]:
                    res = False
                    break
        if not res:
            break
    if not res:
        print(-1)
    else:
        s1 = []
        s2 = []
        for i in range(0, n):
            if color[i] == 1:
                s1.append(i)
            else:
                s2.append(i)
        print(len(s1))
        print(" ".join(str(x + 1) for x in s1))
        print(len(s2))
        print(" ".join(str(x + 1) for x in s2))

main()