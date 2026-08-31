for _ in range(int(input())):
    n=int(input())
    f=0
    
    a=list(map(int,input().split()))
    for i in range(n-2):
        if a[i]+a[i+1]<=a[-1]:
            print(i+1,i+2,n)
            f=1
            break
    if f==0:
        print("-1")