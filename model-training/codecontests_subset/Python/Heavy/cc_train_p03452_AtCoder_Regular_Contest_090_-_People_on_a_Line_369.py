import heapq

N, M = map(int, input().split())

INF = 10 ** 9 + 1
G, dist = [[] for i in range(N)], [INF for j in range(N)]
check, p = [0 for k in range(N)], [-1 for l in range(N)]


def dijkstra(s):
    dist[s], pq = 0, []
    heapq.heappush(pq, (0, s))

    while len(pq) != 0:
        u = heapq.heappop(pq)
        check[u[1]] = 2

        if dist[u[1]] < u[0]:
            continue

        for v in G[u[1]]:
            if check[v[0]] != 2:
                if dist[u[1]] + v[1] < dist[v[0]]:
                    dist[v[0]], check[v[0]] = dist[u[1]] + v[1], 1
                    heapq.heappush(pq, (dist[v[0]], v[0]))


def main():
    data = []
    for i in range(M):
        l, r, d = map(int, input().split())
        G[l-1].append((r-1, d))
        p[r-1] = l - 1
        data.append((l, r, d))

    for i in range(N):
        if p[i] == -1:
            dijkstra(i)

    for i in range(M):
        l, r, d = data[i]
        if dist[r-1] - dist[l-1] != d:
            print("No")
            break
    else:
        print("Yes")


if __name__ == '__main__':
    main()
