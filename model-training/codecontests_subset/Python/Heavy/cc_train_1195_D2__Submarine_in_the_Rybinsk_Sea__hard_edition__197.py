f=[]
u=1
for i in range(23):
    f.append(u%998244353)
    u*=10
def F(sai,saj):
    p=len(sai)
    q=len(saj)
    z=""
    if p>=q:
        for t in range(p-q):
            z+=sai[t]
        for t in range(q):
            z+=sai[t+p-q]
            z+=saj[t]
    else:
        for t in range(q-p):
            z+=saj[t]
        for t in range(p):
            z+=sai[t]
            z+=saj[t+q-p]
    
    c=1
    r=[]
    for i in range(len(z)):
        if z[i]!='a':
            r.append(len(z)-1-i)
    
    return r


def cont(r,k):
    c=0
    for i in range(len(k)-1,-1,-1):
        c+=f[r[i]]*int(k[i])
        c%=998244353
    
    return c        

n=int(input())
a=[int(x) for x in input().split()]
cnt=[0]*11
for i in a:
    cnt[len(str(i))]+=1
d={}
for i in range(11):
    if cnt[i]:
        d[i]=1
k=[]
g=[]
memo={}
for i in range(11):
    k.append('a'*i)
    g.append('b'*i)
for i in k:
    for j in g:
        memo[(len(i),len(j),0)]=F(i,j)
        memo[(len(j),len(i),1)]=F(j,i)
ans=0
for i in a:
    e=str(i)
    for j in d:
        ans+=cnt[j]*(cont(memo[(len(k[j]),len(e),0)],e)+cont(memo[(len(e),len(k[j]),1)],e))%998244353
print(ans%998244353)   
        

    