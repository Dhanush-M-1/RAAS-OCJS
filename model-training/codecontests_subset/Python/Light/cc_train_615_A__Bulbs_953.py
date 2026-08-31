n , m = map(int,input().split())
b1 = []
for i in range (n):
    a = input().split()
    for j in a[1:]:
        b1.append(j)
b2 = list(set(b1))
if m == len(b2):
    print('YES')
else:
    print('NO')