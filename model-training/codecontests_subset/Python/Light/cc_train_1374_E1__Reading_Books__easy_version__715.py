n,k=map(int,input().split())
ar=[];a1=[];b1=[]
for _ in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        ar.append(t)
    elif a==1 and b==0:
        a1.append(t)
    elif b==1 and a==0:
        b1.append(t)
a1=sorted(a1);b1=sorted(b1)
for i in range(min(len(a1),len(b1))):
    ar.append(a1[i]+b1[i])
ar=sorted(ar)    
if len(ar)<k:
    print(-1)
else:
    print(sum(ar[:k]))