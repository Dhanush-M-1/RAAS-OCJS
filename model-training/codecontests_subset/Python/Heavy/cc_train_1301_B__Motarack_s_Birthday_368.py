for i in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    t1=-1
    t2=100000000000
    m=0
    for i in range(n-1):
        if l[i]==-1 and l[i+1]!=-1:
            if l[i+1]>t1:
                t1=l[i+1]
            if l[i+1]<t2:
                t2=l[i+1]
        elif l[i]!=-1 and l[i+1]==-1:
            if l[i]>t1:
                t1=l[i]
            if l[i]<t2:
                t2=l[i]
        elif l[i]!=-1 and l[i+1]!=-1:
            if abs(l[i+1]-l[i])>m:
                m=abs(l[i+1]-l[i])
    if t1==-1:
        if t2==100000000000:
            print(max(m,0),0)
        else:
            print(max(m,0),t2)
    elif t2==100000000000:
            print(max(m,0),t1)
    else:
        k=(t1+t2)//2
        print(max(m,t1-k,k-t2),k)