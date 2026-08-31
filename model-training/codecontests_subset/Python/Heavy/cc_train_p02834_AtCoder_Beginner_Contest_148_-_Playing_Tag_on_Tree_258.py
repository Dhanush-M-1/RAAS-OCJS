import sys
input = sys.stdin.readline
from collections import deque
N, u, v = map(int, input().split())
u, v = u-1, v-1
X = [[] for i in range(N)]
for i in range(N-1):
    x, y = map(int, input().split())
    X[x-1].append(y-1)
    X[y-1].append(x-1)

P = [-1] * N
Q = deque([v])
R = []
while Q:
    i = deque.popleft(Q)
    R.append(i)
    for a in X[i]:
        if a != P[i]:
            P[a] = i
            X[a].remove(i)
            deque.append(Q, a)

DE = [0] * N
for i in R[1:]:
    DE[i] = DE[P[i]] + 1

D = [0] * N
for i in R[::-1]:
    D[i] = max([D[j] for j in X[i]] + [DE[i]])

i = u
ma = D[i]
while True:
    i = P[i]
    if DE[i] * 2 <= DE[u]: break
    ma = max(ma, D[i])

print(ma - 1)
