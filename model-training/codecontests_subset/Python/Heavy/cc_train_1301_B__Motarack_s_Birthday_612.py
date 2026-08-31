t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    b=[a[0]]
    for j in range(1,n):
        if(a[j]!=-1):
            b.append(a[j])
        else:
            if b[len(b)-1]!=-1:
                b.append(-1)
    if(len(b)==1):
        print(0,0)
        continue
    mini=10**9+1
    maxi=-2
    for j in range(len(b)-1):
        if(b[j]==-1):
            if(b[j+1])>maxi:
                maxi=b[j+1]
            if(b[j+1]<mini):
                mini=b[j+1]
        elif(b[j+1]==-1):
            if(b[j])>maxi:
                maxi=b[j]
            if(b[j]<mini):
                mini=b[j]
    k=(maxi+mini)//2
    m=-2
    for j in range(len(b)-1):
        if(b[j]==-1):
            b[j]=k
        if(b[j+1]==-1):
            b[j+1]=k
        if(abs(b[j+1]-b[j])>m):
            m=abs(b[j+1]-b[j])
    print(m,k)