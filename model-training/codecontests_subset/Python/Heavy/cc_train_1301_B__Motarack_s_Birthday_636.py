t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    p=[]
    for i in range(n):
        if a[i]==-1:
            if i-1>=0 :
                if a[i-1]!=-1 :
                    p.append(a[i-1])
            if  i+1<=n-1:
                if a[i+1]!=-1 :
                    p.append(a[i+1])
    if len(p)==0:
        print(0,1)
    else:
        m=(int((max(p)+min(p))/2))
        for i in range(len(a)):
            if a[i]==-1:
                a[i]=m
        ma=0
        for i in range(1,n):
            if abs(a[i]-a[i-1])>ma:
                ma=abs(a[i]-a[i-1])
        print(ma,m)
        
        
 