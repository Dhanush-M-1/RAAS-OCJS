
n,k=map(int,input().split())
a=[]
b=[]
s=[]
ans=0
for i in range(n):
    t,x,y=map(int,input().split())
    if(x==1 and y==1):
        s.append(t)
    elif x==1:
        a.append(t)
    elif y==1:
        b.append(t)
s1=len(s)
s2=len(a)
s3=len(b)
if(s1+s3<k):
    print(-1)
elif s1+s2<k:
    print(-1)
else:
    s.sort()
    a.sort()
    b.sort()
    i=0
    j=0
    v=0
    while(k>0):
        if(s1==0):
            ans+=a[i]+b[i]
            k-=1
            s2-=1
            s3-=1
            i+=1
            j+=1
        elif s2==0 or s3==0:
            ans+=s[v]
            v+=1
            k-=1
            s1-=1
        else:
            k-=1
            if(a[i]+b[j]<=s[v]):
                s2-=1
                s3-=1
                ans+=a[i]+b[j]
                i+=1
                j+=1
            else:
                ans+=s[v]
                v+=1
                s1-=1
    print(ans)

