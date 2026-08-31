import math
t=int(input())
while t:
    t-=1
    n=int(input())
    a=list(map(int,input().split()))
    l=[]
    diff=[]
    for i in range(n-1):
        if a[i] !=-1 and a[i+1] !=-1:
            diff.append(abs(a[i]-a[i+1]))
        elif a[i]==-1 and a[i+1]!=-1:
            l.append(a[i+1])
        elif a[i]!=-1 and a[i+1]==-1:
            l.append(a[i])
    nl=list(set(l))
    if len(nl)>0:
        nk= (max(nl)+min(nl))//2
        m11=abs(nk-max(nl))
    else:
        nk=1
        m=0
        print(m,nk)
        continue
        
    if len(diff)>0:
        m=max(m11,max(diff))
    else:
        m=m11
    print(m,nk)
    
            