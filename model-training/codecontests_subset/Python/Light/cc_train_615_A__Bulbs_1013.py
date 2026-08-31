n,m = [int(x) for x in input().split()]
location = set()
for i in range(n):
    a= [int(x) for x in input().split()]
    length = len(a)
    amount = a[0]
    slocation = set(a[1:length])
    location = location.union(slocation)
u = len(location)
if u == m:
    print('YES')
else:
    print('NO')