def main():
    from collections import deque, defaultdict
    n, m = map(int, input().split())
    g = [[] for _ in range(n + 1)]
    ref = defaultdict(list)
    q = deque([])
    visited = set()
    inf = 10 ** 10
    dist = [-inf] * (n + 1)

    for i in range(m):
        a, b, k = map(int, input().split())
        g[a].append(b)
        g[b].append(a)
        ref[(a, b)] = k


    def dfs(u):
        q.append(u)
        while q:
            v = q.pop()
            visited.add(v)
            for x in g[v]:
                if x not in visited:
                    if ref[(v, x)] != []:
                        y = ref.get((v, x))
                        if dist[x] == -inf:
                            dist[x] = dist[v] + y
                        elif dist[x] != dist[v] + y:
                            print("No")
                            exit()
                    else:
                        y = ref.get((x, v))
                        if dist[x] == -inf:
                            dist[x] = dist[v] - y
                        elif dist[v] != dist[x] + y:
                            print("No")
                            exit()
                    q.append(x)


    for i in range(1, n + 1):
        if i not in visited:
            dist[i] = 1
            dfs(i)
    print("Yes")
if __name__ == '__main__':
    main()