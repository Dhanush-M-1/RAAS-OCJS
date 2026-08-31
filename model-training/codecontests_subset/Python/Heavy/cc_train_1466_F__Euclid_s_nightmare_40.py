from sys import stdin,stdout
n,m=[int(i) for i in stdin.readline().split()]
l=[]
d1={}
a=[]
p=[i for i in range(m)]
r=[0 for i in range(m)]
mod=10**9+7
def find(x):
    while p[x]!=x:
        x=p[x]
    return x
def power(x):
    f=1
    ct=2
    while x:
        if x%2==1:
            f=f*ct
            f%=mod
        ct=ct*ct
        ct%=mod
        x//=2
    return f
for i in range(n):
    x=[int(j)-1 for j in stdin.readline().split()][1:]
    if len(x)==1:
        x[0]=find(x[0])
        if d1.get(x[0],0)==0:
            l.append(i)
            d1[x[0]]=1
    else:
        u,v=find(x[0]),find(x[1])
        if (d1.get(u,0)==1 and d1.get(v,0)==1):
            continue
        elif u==v:
            continue
        elif d1.get(u,0)==1:
            d1[v]=1
            l.append(i)
        elif d1.get(v,0)==1:
            d1[u]=1
            l.append(i)
        else:
            px=u
            py=v
            if r[px]>r[py]:
                p[py]=px
            elif r[px]<r[py]:
                p[px]=py
            else:
                p[py]=px
                r[px]+=1
            l.append(i)
stdout.write(str(power(len(l)))+" "+str(len(l))+'\n')
for i in l:
    stdout.write(str(i+1)+" ")
