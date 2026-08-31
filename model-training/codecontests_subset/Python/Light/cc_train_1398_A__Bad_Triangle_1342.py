for _ in range(int(input())):
    n=int(input())
    a=list(int(num) for num in input().split())
    ans=[1,2,n]
    if a[0]+a[1]>a[n-1]:
        print("-1")
    else:
        print(*ans)
