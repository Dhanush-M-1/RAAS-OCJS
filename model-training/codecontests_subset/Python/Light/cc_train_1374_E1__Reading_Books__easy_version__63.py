n,k=map(int,input().split())
l,l1,l2=[],[],[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        l.append(t)
    if a==1 and b==0:
        l1.append(t)
    if a==0 and b==1:
        l2.append(t)
l1.sort()
l2.sort()
for i in range(min(len(l1),len(l2))):
    l.append(l1[i]+l2[i])
l.sort()
if len(l)<k:
    print(-1)
else:
    print(sum(l[:k]))

