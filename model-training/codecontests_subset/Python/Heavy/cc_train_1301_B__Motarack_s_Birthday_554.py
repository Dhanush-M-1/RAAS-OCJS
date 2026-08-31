n=int(input())
for i in range(n):
    t=int(input())
    l=input().split()
    for j in range(t):
        l[j]=int(l[j])
    maxx=-1
    minn=1000000000
    for j in range(t):
        if (j!=0 and j!=t-1):
            if  l[j]!=-1 and (l[j-1]==-1 or l[j+1]==-1):
                if (l[j]<minn):
                    minn=l[j]
                if (l[j]>maxx):
                    maxx=l[j]
        elif (j==0):
            if  l[j]!=-1 and  l[j+1]==-1:
                if (l[j]<minn):
                    minn=l[j]
                if (l[j]>maxx):
                    maxx=l[j]
        else:
            if  l[j]!=-1 and l[j-1]==-1:
                if (l[j]<minn):
                    minn=l[j]
                if (l[j]>maxx):
                    maxx=l[j]
    k=int((maxx+minn)/2)
    maxx=0
    for j in range(t-1):
        if (l[j]==-1):
            l[j]=k
        if(l[j+1]==-1):
            l[j+1]=k
        if (abs(l[j]-l[j+1])>maxx):
            maxx=abs(l[j]-l[j+1])
    print (maxx,end=' ')
    print (k)
        
    
        
    
