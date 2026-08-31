
a , b = map(int , input().split())
l = []
for i in range(a):
    x = [int(x) for x in input().split()]
    for j in range(1 , len(x)):
        if x[j] not in l:
            l.append(x[j])
            
print('YES' if len(l) == b else 'NO')