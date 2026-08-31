n,k,m=map(int,input().split())
lst=list(map(int,input().split()))
l=[]
s=sum(lst)
lst.sort()
g=n
h=m
for r in range(g+1):
    ans=0
    m=h
    
    n=g-r
    if s*r<=m:
        
        ans+=(k+1)*r
        #print(k,r,ans)
        m=m-s*r
        c=0
        while 1:
            if c>=k:
                break
            t=m//lst[c]
            #print("t=",t,r,m)
            if t<=0:
                break
            #print(r)
            if(t>n):
                m=m-n*lst[c];
                ans+=n
            else:
                m=m-t*lst[c]
                ans+=t
            c+=1
            #print(r,ans)
        l.append(ans)
    else:
        #print(r*s,m,"fgd")
        break
print(max(l))