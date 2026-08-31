a, b = map(int,input().split())
c= []

for i in range(a):
    d = list(map(int,input().split()))
    for i in d[1:]:
        c.append(i)
e = list(set(c))
if len(e)==b:
    print('YES')
else:
    print('NO')