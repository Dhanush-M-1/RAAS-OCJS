t=int(input())
for _ in range(t):
    n=int(input())
    arr=list(map(int,input().split()))
    s=arr[0]+arr[1]
    f=0
    th=0
    for i in range(2,n):
        if s > arr[i]:
            continue
        else:
            f=1
            th=i
    if f==1:
        print("1 2",end=" ")
        print(th+1)
    else:
        print(-1)
        
    