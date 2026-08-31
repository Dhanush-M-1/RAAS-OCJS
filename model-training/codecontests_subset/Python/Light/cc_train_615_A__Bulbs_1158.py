n,m = map(int, input().split())
j = []
for i in range(n):
    l = list(map(int,input().split(' ')))
    for i in range(1,len(l)):
        if l[i] not in j:
            j.append(l[i])
if len(j) == m:
    print('YES')
else:
    print('NO')    