n , m = map(int,input().split())
b = set()
for i in range (n):
    a = input().split()
    for j in a[1:]:
        b.add(j)
if m == len(b):
    print('YES')
else:
    print('NO')