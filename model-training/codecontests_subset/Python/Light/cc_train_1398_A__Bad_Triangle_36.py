for t in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    c=0
    d=0
    for i in range(2,n):
        if(a[0]+a[1]<=a[i]):
            c=1
            d=i
            break
    if(c==1):
        print(1,2,d+1)
    else:
        print(-1)