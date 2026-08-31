# cook your dish here
import math
n,k=map(int,input().split(" "))
a=list(map(int,input().split()))
a=sorted(a)
m=max(a)//2
c=[a[0]]
d=[1]
for i in range(1,n):
    if a[i]==c[-1]:
        d[-1]+=1
    else:
        c.append(a[i])
        d.append(1)
#print(c,d)        
if max(d)>=k:
    print(0)
else:
    c=[[-1 for i in range(n)] for j in range(m+1)]
    s=[]
    i=n-1
    while i>=0:
        q=a[i]
        if q<=m:
            c[q][i]=0
        k1=1
        while q!=0:
            
            q=q//2
            c[q][i]=k1
            k1=k1+1
        i-=1
    for i in c:
        j=0
        k1=k
        count=0
        while j<n and k1>0:
            if i[j]!=-1:
                count+=i[j]
                k1-=1
            j+=1
        
        if k1==0:
            s.append(count)
    
    print(min(s))
            
            
        

