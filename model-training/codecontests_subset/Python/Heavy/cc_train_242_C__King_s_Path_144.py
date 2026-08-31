MAX = 10**9
d_row = [-1, -1, -1, 0, 0, 1, 1, 1]
d_clm = [-1, 0, 1, -1, 1, -1, 0, 1]

def BFS(S, T):
    dist[S] = 0
    queue = [S]
    while queue:
        u = queue.pop(0)
        if u == T:
            break

        u_row = u // MAX
        u_clm = u % MAX    
        for i in range(8):
            v = (u_row + d_row[i])*MAX + u_clm + d_clm[i]
            if v in dist and dist[v] == MAX:
                queue.append(v)
                dist[v] = dist[u] + 1  

    return (-1 if dist[T] == MAX else dist[T])

dist = {}
s_row, s_clm, t_row, t_clm = map(int, input().split())

S = s_row*MAX + s_clm
dist[S] = MAX

T = t_row*MAX + t_clm
dist[T] = MAX

n = int(input())
for _ in range(n):
    r, a, b = map(int, input().split())
    for i in range(a, b + 1):
        dist[r*MAX + i] = MAX

print(BFS(S, T))