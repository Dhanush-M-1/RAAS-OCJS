t=int(input())
for i in range(t):
    n=int(input())
    mx=0
    mn=10000000000
    ar=[int(x) for x in input().split()]
    for j in range(n):
        if(ar[j]==-1):
            if(j==0):
                if(ar[j+1]!=-1):
                    mx=max(mx,ar[j+1])
                    mn=min(mn,ar[j+1])
            elif(j==n-1):
                if(ar[j-1]!=-1):
                    mx=max(mx,ar[j-1])
                    mn=min(mn,ar[j-1])
            else:
                if(ar[j-1]!=-1):
                    mx=max(mx,ar[j-1])
                    mn=min(mn,ar[j-1])
                if(ar[j+1]!=-1):
                    mx=max(mx,ar[j+1])
                    mn=min(mn,ar[j+1])
    if(mn==10000000000):
        mn=0
    k=(mn+mx)//2
    for j in range(n):
        if(ar[j]==-1):
            ar[j]=k
    md=0
    for j in range(n-1):
        md=max(md,abs(ar[j]-ar[j+1]))
    print(md,k,sep=" ")
                
