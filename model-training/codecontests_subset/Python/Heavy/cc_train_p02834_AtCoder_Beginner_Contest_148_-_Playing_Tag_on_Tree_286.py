from sys import exit
N, u, v = map(int, input().split())

if u == v:
    print(0)
    exit()

edges = [[] for _ in range(N+1)]

for _ in range(N-1):
    A, B = map(int, input().split())
    edges[A].append(B)
    edges[B].append(A)

def calDist(start, edges):
    dest = [-1] * (N + 1)
    dest[start] = 0
    q = [start]
    while len(q) != 0:
        current = q.pop()
        for n in edges[current]:
            if dest[n] != -1:
                continue
            dest[n] = dest[current] + 1
            q.append(n)
    return dest

T = calDist(u, edges)
A = calDist(v, edges)

result = 0
for i in range(1, N+1):
    A_i = A[i]
    if T[i] >= A_i:
        continue
    if A_i > result:
        result = A_i

print(result-1)

