n,k=map(int,input().split())
l,l1,l2=[],[],[]
for i in range(n):
    a,b,c=map(int,input().split())
    if b==1 and c==1:
        l.append(a)
    elif b==1 and c==0:
        l1.append(a)
    elif b==0 and c==1:
        l2.append(a)
l1.sort()
l2.sort()
for j in range(min(len(l1),len(l2))):
    l.append(l1[j]+l2[j])
l.sort()
if len(l)<k:
    print(-1)
else:
    print(sum(l[:k]))