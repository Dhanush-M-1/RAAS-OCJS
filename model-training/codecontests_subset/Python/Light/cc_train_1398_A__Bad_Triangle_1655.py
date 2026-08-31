for _ in range (int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    s=a[0]+a[1]
    f=0
    for i in range (2,n):
        if s<=a[i]:
            print("1 2",i+1)
            f=1
            break
    if f==0:
        print("-1")
        