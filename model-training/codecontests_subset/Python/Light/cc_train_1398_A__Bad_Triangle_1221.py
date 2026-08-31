for i in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))[:n]
    print(*([1,2,n],[-1])[a[0]+a[1]>a[-1]])
    