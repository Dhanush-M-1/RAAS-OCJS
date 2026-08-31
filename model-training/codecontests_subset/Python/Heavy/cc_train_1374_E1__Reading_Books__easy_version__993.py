n,k=map(int,input().split())
a=0
b=0
alike=[]
blike=[]
bothlike=[]
for _ in range(n):
    t,aa,bb=map(int,input().split())
    if aa==1:
        a+=1
    if bb==1:
        b+=1
    if aa==1 and bb==0:
        alike.append(t)
    elif aa==0 and bb==1:
        blike.append(t)
    elif aa==1 and bb==1:
        bothlike.append(t)
if a<k or b<k:
    print(-1)
else:
    alike.sort()
    blike.sort()
    la=len(alike)
    lb=len(blike)
    ans=0
    if la<k and lb>=k:
        for i in range(la):
            bothlike.append(alike[i]+blike[i])
        bothlike.sort()
        ans=sum(bothlike[:k])
    elif lb<k and la>=k:
        for i in range(lb):
            bothlike.append(alike[i]+blike[i])
        bothlike.sort()
        ans=sum(bothlike[:k])
    elif la>=k and lb>=k:
        for i in range(k):
            bothlike.append(alike[i]+blike[i])
        bothlike.sort()
        ans=sum(bothlike[:k])
    else:
        for i in range(min(la,lb)):
            bothlike.append(alike[i]+blike[i])
        bothlike.sort()
        ans=sum(bothlike[:k])
    print(ans)
