n,k = map(int,input().split())
aa=[]
bb=[]
l=[]
for _ in range(n):
    t,a,b=map(int,input().split())
    sum1=0
    sum2=0
    if a&b:
        l.append(t)
    elif a==1:
        aa.append(t)
    elif b==1:
        bb.append(t)
bb.sort()
aa.sort()
nn=min(len(aa),len(bb))
for i in range(nn):
    l.append(bb[i]+aa[i])
if k> len(l):
    print(-1)
else:
    l.sort()
    sum1=0
    for i in range(k):
        sum1+=l[i]
    print(sum1)
