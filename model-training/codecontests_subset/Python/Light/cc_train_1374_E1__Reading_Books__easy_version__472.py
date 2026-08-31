from sys import maxsize
n, k = map(int, input().split())
l = [[0], [0], [0], [0]]
x = []
ans = maxsize
for i in range(n):
    x.append(list(map(int, input().split())))
x.sort()
for p in x:
    temp = l[p[1]*2 + p[2]][-1]
    l[p[1]*2 + p[2]].append(temp + p[0])
for i in range(min(k + 1, len(l[3]))):
    if k - i < len(l[1]) and k - i < len(l[2]):
        ans = min(ans, l[3][i] + l[1][k - i] + l[2][k - i])
if ans == maxsize:
    print(-1)
else:
    print(ans)

 

