T=int(input())
for i in range(T):
    N=int(input())
    lst=list(map(int,input().split()))
    lst.sort()
    if N<3:
        print(-1)
    else:
        x=lst[0]
        y=lst[1]
        z=lst[-1]
        if x+y>z:
            print(-1)
        else:
            print(1,2,N,sep=" ")