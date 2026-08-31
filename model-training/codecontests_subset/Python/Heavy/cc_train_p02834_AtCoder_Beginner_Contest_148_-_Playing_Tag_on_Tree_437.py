from collections import deque

N,u,v = map(int,input().split())

root = [[] for i in range(N)]
for _ in range(N-1):
    a, b = (int(x) for x in input().split())
    root[b-1].append(a-1)
    root[a-1].append(b-1) 

def search(p):
    stack=deque([p])
    check = [-1]*N
    check[p] = 0

    while len(stack)>0:
        v = stack.popleft()
        for i in root[v]:
            if check[i] == -1:
                check[i]=check[v]+1
                stack.append(i)
    return check

taka = search(u-1)
aoki = search(v-1)
ans = 0
for i in range(N):
    if taka[i] < aoki[i]:
        ans = max(ans, aoki[i]-1)
print(ans)