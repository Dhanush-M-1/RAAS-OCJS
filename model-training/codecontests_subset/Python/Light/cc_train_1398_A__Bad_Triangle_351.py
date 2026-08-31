for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    i = n-3
    while i>=0 and a[i]+a[i+1]>a[n-1]:
        i-=1

    if i==-1:
        print(-1)
    else:
        print(i+1,i+2,n)
