from collections import deque

N, T, A, *AB = map(int, open(0).read().split())

E = [[] for _ in range(N + 1)]
for a, b in zip(*[iter(AB)] * 2):
    E[a].append(b)
    E[b].append(a)

takahashi = [-1] * (N + 1)
takahashi[T] = 0
Q = deque([T])
while Q:
    a = Q.popleft()
    for b in E[a]:
        if takahashi[b] != -1:
            continue
        takahashi[b] = takahashi[a] + 1
        Q.append(b)

aoki = [-1] * (N + 1)
aoki[A] = 0
Q = deque([A])
while Q:
    a = Q.popleft()
    for b in E[a]:
        if aoki[b] != -1:
            continue
        aoki[b] = aoki[a] + 1
        Q.append(b)

ma = 0
for t, a in zip(takahashi[1:], aoki[1:]):
    if t < a:
        ma = max(ma, a)

print(ma - 1)
