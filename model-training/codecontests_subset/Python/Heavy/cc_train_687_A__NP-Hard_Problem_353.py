from collections import deque
n, m = list(map(int,input().split()))
g = [[] for i in range(n)]
a = []
for i in range(m):
    a.append(list(map(int,input().split())))
for i in a:
    g[i[0]-1].append(i[1]-1)
    g[i[1]-1].append(i[0]-1)

dola1 = set()
dola2 = set()
used = [0]*n
for i in range(n):
    if not used[i]:
        used[i] = 1
        q = deque()
        q.append(i)
        dola1.add(i)
        k = 0
        while q:
            v = q.popleft()
            for j in g[v]:
                if not used[j]:
                    used[j] = 1
                    q.append(j)
                    if v in dola1:
                        dola2.add(j)
                    else:
                        dola1.add(j)
                else:
                    if v in dola1:
                        if j in dola1:
                            print(-1)
                            exit()
                    else:
                        if j in dola2:
                            print(-1)
                            exit()
                k += 1

print(len(dola1))
for i in dola1:
    print(i+1, end = ' ')
print()
print(len(dola2))
for i in dola2:
    print(i+1, end = ' ')
