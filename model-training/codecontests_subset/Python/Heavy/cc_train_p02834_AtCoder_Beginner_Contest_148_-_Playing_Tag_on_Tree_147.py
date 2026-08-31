from collections import deque

def bfs(s):
    stack=deque([s])
    check = [-1]*n
    check[s] = 0
    while len(stack)>0:
        v = stack.popleft()
        for i in root[v]:
            if check[i] == -1:
                check[i]=check[v]+1
                stack.append(i)
    return check

n,u,v = map(int,input().split())

root = [[] for i in range(n)]
for _ in range(n-1):
    a, b = (int(x) for x in input().split())
    root[b-1].append(a-1)
    root[a-1].append(b-1)

takahashi_root = bfs(u-1)
aoki_root = bfs(v-1)

ans = 0

for i in range(n):
    if takahashi_root[i] < aoki_root[i]:
        ans = max(ans,aoki_root[i]-1)
print(ans)
