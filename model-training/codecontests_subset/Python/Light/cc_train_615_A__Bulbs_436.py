n, m = map(int, input().split())
a = []
for i in range(n):
    a.append(input().split())
    del a[i][0]
# print(a) 
for i in range(1, n):
    a[0] += a[i]
l = []
l = a[0]
l = list(set(l))
l.sort()
# print(l)
if(len(l) == m):
    print('YES')
else:   print('NO')    