import math
t=int(input())
for i in range(t):
    n=int(input())
    l=[]
    li=list(map(int,input().split()))
    for k in range(n):
        if(li[k]==-1):
            if(k-1>=0):
                if(li[k-1]!=-1):
                    l.append(li[k-1])
            if(k+1<n):
                if(li[k+1]!=-1):
                    l.append(li[k+1])
    if(l==[]):
        ans=0
    else:
        a=max(l)
        b=min(l) 
        ans=(a+b)//2 
    for k in range(n):
        if(li[k]==-1):
            li[k]=ans
    maxi=0
    for k in range(1,n):
        if(abs(li[k]-li[k-1])>maxi):
            maxi=abs(li[k]-li[k-1]) 
    print(maxi,end=" ")
    print(ans)