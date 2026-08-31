for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    print(*([1,2,n],[-1])[a[0]+a[1]>a[n-1]])