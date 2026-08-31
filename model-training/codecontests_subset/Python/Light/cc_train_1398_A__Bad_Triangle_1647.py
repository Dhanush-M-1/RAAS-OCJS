for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    l=0;l1=1;l2=2
    t=0
    while l2<n:
        #print(a[l]+a[l1],a[l2])
        if a[l]+a[l1]>a[l2]:
            l2+=1
        else:
            print(l+1,l1+1,l2+1)
            t=1
            break
    if t==0:
        print(-1)
        