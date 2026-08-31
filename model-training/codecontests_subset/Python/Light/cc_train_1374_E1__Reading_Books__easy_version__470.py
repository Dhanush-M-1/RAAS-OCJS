n,k=list(map(int,input().split()))
l,l1,l2=[],[],[] 
for _ in range(n):
    x,y,z=list(map(int,input().split()))
    if y==1 and z==1:
        l.append(x)
    elif y==1:
        l1.append([x,y,z])
    elif z==1:
        l2.append([x,y,z])
l1.sort()
l2.sort()
for i in range(min(k,len(l1),len(l2))):
    a=l1[i][0]
    b=l2[i][0]
    l.append(a+b)
l.sort()
if len(l)>=k:
    print(sum(l[:k]))
else:
    print(-1)
    
    
    
