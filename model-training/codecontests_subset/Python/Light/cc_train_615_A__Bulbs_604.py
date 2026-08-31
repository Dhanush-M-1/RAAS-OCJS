n,m = map(int,input().split())
s = set()
for i in range(n):
       a = list(map(int,input().split()))
       z = a[0]
       for x in a[1:]:
              s.add(x)
if len(s) == m:
       print('YES')
else:
       print('NO')