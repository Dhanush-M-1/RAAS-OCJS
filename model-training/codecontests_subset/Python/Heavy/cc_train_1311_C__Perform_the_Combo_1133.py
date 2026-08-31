for i in range(int(input())):
    n,m=map(int,input().split())
    s=input()
    l=list(map(int,input().split()))
    d={}
    for i in range(97,123):
        d[chr(i)]=0
    l.append(n)
    l.sort(reverse=True)
    a=[0 for i in range(n)]
    x=0
    y=0
    for i in range(m+1):
        x+=1
        a[l[i]-1]=x
    k=-1
    for i in range(n-1,-1,-1):
        if a[i]!=0:
            k=a[i]
        else:
            a[i]+=k
    #print(a)
    for i in range(n):
        d[s[i]]+=a[i]
    for i in d:
        print(d[i],end=" ")
    print()
        
    