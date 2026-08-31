import sys
from collections import deque

n,m = map(int, input().split())
adj_list = [[] for i in range(n)]
for i in range(m):
    l, r, d = map(int, input().split())
    adj_list[l-1].append((r-1, d))
    adj_list[r-1].append((l-1, -d))
def search(start, dist_all):
    q = deque([start])
    dist_all[i] = 0
    while(len(q) > 0):
        w = q.popleft()
        for x in adj_list[w]:
            if dist_all[x[0]] is None:
                dist_all[x[0]] = dist_all[w] + x[1]
                q.append(x[0])
            elif dist_all[x[0]] != dist_all[w] + x[1]:
                return False
    return True
dist_all = [None for i in range(n)]
for i in range(n):
    if dist_all[i] is None:
        if not search(i, dist_all):
            print('No')
            exit(0)
print('Yes')