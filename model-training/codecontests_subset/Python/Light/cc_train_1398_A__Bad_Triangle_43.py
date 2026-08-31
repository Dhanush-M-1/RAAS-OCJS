for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    if a[0]+a[1]<=a[n-1] or a[0]+a[n-1]<=a[1] or a[1]+a[n-1]<=a[0]:
        print(1,2,n)
    else:
        print("-1")