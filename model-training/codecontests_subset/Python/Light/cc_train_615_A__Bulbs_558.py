n,m = [int(x) for x in input().split()]
a = []
count = 0
for i in range(n):
    k = [int(y) for y in input().split()]
    for elem in k:
        a.append(elem)
    a.remove(k[0])

for j in range(1,m+1):
    if j not in a:
        count +=1

if count > 0:
    print('NO')
else:
    print('YES')
            
            
    