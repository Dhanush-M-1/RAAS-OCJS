
t=int(input())

while t:
    n=int(input())
    a=list(map(int,input().split()))
    dif=0
    for i in range(n-1):
        if a[i]!=-1 and a[i+1]!=-1:
           if abs(a[i]-a[i+1])>dif:
               dif=abs(a[i]-a[i+1])
    b=[]
    for i in range(n):
       if i==0:
           if a[i]!=-1 and a[i+1]==-1:
               b.append(a[i])
       elif i==n-1:
           if a[i]!=-1 and a[i-1]==-1:
               b.append(a[i])
       elif a[i]!=-1:
           if a[i-1]==-1 or a[i+1]==-1:
               b.append(a[i])
    
    b.sort()
    if len(b)!=0:
        k=(b[0]+b[len(b)-1])//2
        ans=max(dif,k-b[0],b[len(b)-1]-k)
        print(ans,k)
    else:
        print(0,0)
    
    t-=1