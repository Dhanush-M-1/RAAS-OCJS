def F(sai,saj):
    p=len(sai)
    q=len(saj)
    if p>=q:
        z=""
        for t in range(p-q):
            z+=sai[t]
        for t in range(q):
            z+=sai[t+p-q]
            z+=saj[t]
    else:
        z=""
        for t in range(q-p):
            z+=saj[t]
        for t in range(p):
            z+=sai[t]
            z+=saj[t+q-p]
    c=1
    r=0
    for i in range(len(z)-1,-1,-1):
        if z[i]!='a':
            r+=c*int(z[i])
        c*=10
    return r

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
for i in range(11):
    k.append('a'*i)
# print(k)
ans=0
for i in a:
    for j in d:
        ans+=cnt[j]*(F(k[j],str(i))+F(str(i),k[j]))%998244353
print(ans%998244353)   

    