n, m = map(int, input().split())
d = {}
for i in range(n):
    ls = list(map(int, input().split()))
    for i in ls[1:]: d[i] = 1
cnt = 0
for k, v in d.items():
    cnt+=1
if cnt<m: print('NO')
else: print('YES')
