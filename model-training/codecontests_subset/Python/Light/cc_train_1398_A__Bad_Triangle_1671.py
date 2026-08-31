for _ in range(int(input())):
    n=int(input())
    arr=list(int(i) for i in input().split())
    mn1=arr[0]
    mn2=arr[1]
    mx1=arr[-1]
    if mn1+mn2>mx1:
        print(-1)
    else:
        print(1,2,n)