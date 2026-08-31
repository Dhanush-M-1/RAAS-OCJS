n,k=map(int,input().split())
t=[]
a=[]
b=[]
an=k
bn=k
for i in range(n):
    t1,a1,b1=map(int,input().split())
    t.append(t1)
    a.append(a1)
    b.append(b1)
both_like=[]
a_like=[]
b_like=[]
for i in range(n):
    if(a[i]==1 and b[i]==1):
        both_like.append(t[i])
    elif(a[i]==1 and b[i]==0):
        a_like.append(t[i])
    elif(a[i]==0 and b[i]==1):
        b_like.append(t[i])
both_like.sort()
a_like.sort()
b_like.sort()
ans=0
i=0
j=0
k=0
while(i<len(both_like) and an>0 and bn>0):
    if(j<len(a_like) and k<len(b_like) and both_like[i]>=a_like[j]+b_like[k]):
        ans+=a_like[j]+b_like[k]
        j+=1
        k+=1
        an-=1
        bn-=1
        
    else:
        ans+=both_like[i]
        i+=1
        an-=1
        bn-=1
        
while(an>0 and j<len(a_like)):
    ans+=a_like[j]
    j+=1
    an-=1

while(bn>0 and k<len(b_like)):
    ans+=b_like[k]
    k+=1
    bn-=1
if(an==0 and bn==0):
    print(ans)
else:
    print(-1)           
