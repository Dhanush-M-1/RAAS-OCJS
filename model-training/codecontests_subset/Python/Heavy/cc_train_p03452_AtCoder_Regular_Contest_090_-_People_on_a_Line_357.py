from collections import deque



def main():
    n, m = map(int, input().split())
    graph = [[] for i in range(n)]
    for _ in range(m):
        l, r, d = map(int, input().split())
        graph[l - 1] += [(r - 1, d)]
        graph[r - 1] += [(l - 1, -d)]


    que = deque()
    lines = [None] * n


    for i in range(n):
        if lines[i] is not None:
            continue
        lines[i] = 0
        que.append(i)
        while que:
            cur = que.popleft()
            for nxt, cost in graph[cur]:
                if lines[nxt] is None:
                    lines[nxt] = lines[cur] + cost
                    que.append(nxt)
                else:
                    if lines[nxt] != lines[cur] + cost:
                        return 'No'
    return 'Yes'



print(main())