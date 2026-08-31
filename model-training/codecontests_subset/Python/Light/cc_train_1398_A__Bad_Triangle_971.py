T=int(input())
for _ in range(T):
    n=int(input())
    arr=list(map(int,input().split()))
    if n==3:
        if arr[0]+arr[1]>arr[2]:
            print(-1)
        else:
            print(1,2,3)
    else:
        f1=1
        for i in range(n-1):
            f=1
            if arr[i]+arr[i+1]<=arr[-1]:
                f=0
                x,y,z=i+1,i+2,n
            if f:
                continue
            else:
                f1=0
                break
        if f1:
            print(-1)
        else:
            print(x,y,z)
                
