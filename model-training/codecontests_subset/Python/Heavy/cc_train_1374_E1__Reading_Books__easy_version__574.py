def abc(l,n,i,x,y,m,k):
    if x>=k and y>=k:
        return m
    if i==n:
        return -1
    ans=-1
    ans=abc(l,n,i+1,x,y,m,k)
    c=abc(l,n,i+1,x+l[i][1],y+l[i][2],m+l[i][0],k)
    if c!=-1:
        if ans==-1:
            ans=c
        else:
            ans=min(ans,c)
    return ans
n,k=map(int,input().split())
l=[]
for i in range(n):
    l.append(list(map(int,input().split())))
#print(abc(l,n,0,0,0,0,k))

d={}
d[0,0]=[]
d[0,1]=[]
d[1,0]=[]
d[1,1]=[]
for i in l:
    d[i[1],i[2]]+=[i[0]]
for i in d:
    d[i]=sorted(d[i],reverse=True)
#print(d)
ans=0
while k>0:
    if len(d[1,1])==0:
        if len(d[0,1])==0 or len(d[1,0])==0:
            break
        ans+=d[0,1][-1]+d[1,0][-1]
        del(d[0,1][-1])
        del(d[1,0][-1])
        k-=1
    else:
        if len(d[0,1])==0 or len(d[1,0])==0:
            ans+=d[1,1][-1]
            del(d[1,1][-1])
            k-=1
        else:
            x=d[0,1][-1]+d[1,0][-1]
            if x<=d[1,1][-1]:
                ans+=d[0,1][-1]+d[1,0][-1]
                del(d[0,1][-1])
                del(d[1,0][-1])
                k-=1
            else:
                ans+=d[1,1][-1]
                del(d[1,1][-1])
                k-=1
if k==0:
    print(ans)
else:
    print(-1)
                
