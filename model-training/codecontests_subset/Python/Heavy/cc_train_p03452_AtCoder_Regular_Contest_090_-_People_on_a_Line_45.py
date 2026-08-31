from collections import deque

N, M = map(int, input().split())

adjList = [[] for i in range(N)]
for i in range(M):
    L, R, D = map(int, input().split())
    adjList[L - 1].append((R - 1, D))
    adjList[R - 1].append((L - 1, -D))

def bfs(vSt):
    xs[vSt] = 0
    Q = deque()
    Q.append(vSt)
    while Q:
        vNow = Q.popleft()

        for v2, d in adjList[vNow]:
            x2 = xs[vNow] + d
            if xs[v2] == None:
                xs[v2] = x2
                Q.append(v2)
            elif xs[v2] != x2:
                return False

    return True


xs = [None] * N
for vSt in range(N):
    if xs[vSt] == None:
        if not bfs(vSt):
            print('No')
            exit()

print('Yes')
