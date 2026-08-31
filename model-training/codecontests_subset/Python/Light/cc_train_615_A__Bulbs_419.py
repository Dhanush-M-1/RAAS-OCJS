a=input().split()
n=int(a[0])
m=int(a[1])
l=[]
for i in range(n):
    b=input().split()
    for j in range(int(b[0])):
        l.append(b[j+1])
if len(set(l))==m:
    print('YES')
else:
    print('NO')