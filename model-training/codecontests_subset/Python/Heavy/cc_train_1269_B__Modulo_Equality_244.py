n,m=map(int,input().split())
a=input().split()
b=input().split()
c=list(set(a))
d=list(set(b))
e=[[0,c[i]] for i in range(len(c))]
f=[[0,d[i]] for i in range(len(d))]
for i in range(len(c)):
    for j in range(n):
        if(c[i]==a[j]):
            e[i][0]+=1
for i in range(len(d)):
    for j in range(n):
        if(d[i]==b[j]):
            f[i][0]+=1
e.sort()
f.sort()
ans=10**9+1
for i in range(n):
    a[i]=int(a[i])
    b[i]=int(b[i])
a.sort()
b.sort()
for i in range(len(f)):
    if(e[0][0]==f[i][0]):
        g=[]
        h=(int(f[i][1])-int(e[0][1]))%m
        for j in range(n):
            g.append((a[j]+h)%m)
        g.sort()
        if(g==b):
            ans=min(ans,h)
print(ans)    