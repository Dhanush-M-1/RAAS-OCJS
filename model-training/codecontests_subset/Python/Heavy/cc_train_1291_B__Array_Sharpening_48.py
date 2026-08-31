for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    flag=0
    for i in range(n//2):
        if a[i]<i:
            flag=1
    if n&1:
        for i in range(n//2,n):
            if a[i]<n-i-1:
                flag=1
    else:
        if((a[n//2-1]>=n//2 and a[n//2]>=n//2-1) or (a[n//2-1]>=n//2-1 and a[n//2]>=n//2)):
            pass
        else:
            flag=1
        for i in range(n//2,n):
            if a[i]<n-i-1:
                flag=1
    if flag==1:
        print('No')
    else:
        print('Yes')
