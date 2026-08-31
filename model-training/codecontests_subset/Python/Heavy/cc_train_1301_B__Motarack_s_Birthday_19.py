for i in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    v=set()
    m=0
    #print(a)
    for i in range(n-1):
        #print(i)
        #print(a[i])
        #print(v)
        if a[i]==-1:
            if (i!=0 and a[i-1]>=0) :
                v.add(a[i-1])
            if a[i+1]>=0 :
                v.add(a[i+1])
    if a[n-1]==-1:
        if a[n-2]>=0:
            v.add(a[n-2])
    if not v:
        print(0,0)
        continue
    k=abs(max(v)+min(v))//2
    for i in range(n):
        if a[i]==-1:
            a[i]=k
    for i in range(n-1):
        if abs(a[i+1]-a[i])>m:
            m=abs(a[i+1]-a[i])
    print(m,k)