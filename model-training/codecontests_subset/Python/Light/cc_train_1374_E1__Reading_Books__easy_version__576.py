n,k = map(int,input().split())
a = []
b = []
anb = []
for i in range(n):
    x,y,z = map(int,input().split())
    if(y == 0 and z == 1):
        b.append(x)
    elif(y==1 and z==0):
        a.append(x)
    elif(y==1 and z==1):
        anb.append(x)
a.sort()
b.sort()
if(len(a) < len(b)):
    b = b[:len(a)]
else:
    a = a[:len(b)]
for i in range(len(a)):
    a[i] += b[i]
anb += a
anb.sort()
ans = 0
if(len(anb) < k):
    print(-1)
else:
    print(sum(anb[:k]))
