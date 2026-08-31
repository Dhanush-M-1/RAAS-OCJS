n,x,y=map(int,input().split())
s=[[]for i in range(n+1)]
for i in range(n-1):
    a,b=map(int,input().split())
    s[a].append(b)
    s[b].append(a)
p=[float("INF")for i in range(n+1)]
q=[float("INF")for i in range(n+1)]
p[x]=0
q[y]=0
c=set([x])
while c:
    d=set()
    for i in c:
        for j in s[i]:
            if p[j]>p[i]+1:
                p[j]=p[i]+1
                d.add(j)
    c=d
c=set([y])
while c:
    d=set()
    for i in c:
        for j in s[i]:
            if q[j]>q[i]+1:
                q[j]=q[i]+1
                d.add(j)
    c=d
a=0
for i in range(1,n+1):
    if p[i]<q[i]:
        a=max(a,q[i]-1)
print(a)