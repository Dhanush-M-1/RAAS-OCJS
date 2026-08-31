import sys
from collections import deque

n, m = map(int, sys.stdin.buffer.readline().decode('utf-8').split())
adj = [set() for _ in range(n)]
for u, v in (map(int, line.decode('utf-8').split()) for line in sys.stdin.buffer):
    adj[u-1].add(v-1)
    adj[v-1].add(u-1)

dq = deque(range(n))
ans = []

while dq:
    stack = [dq.popleft()]
    size = 1

    while stack:
        v = stack.pop()
        for _ in range(len(dq)):
            if dq[0] not in adj[v]:
                size += 1
                stack.append(dq.popleft())
            dq.rotate()

    ans.append(size)

print(len(ans))
print(*sorted(ans))
