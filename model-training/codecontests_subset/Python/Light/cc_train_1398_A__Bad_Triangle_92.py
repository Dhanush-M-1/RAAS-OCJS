t=int(input())
for k in range(t):
    n=int(input())
    flag=0
    a= list(map(int,input().split()))
    temp=a[0]+a[1]
    if(a[n-1]>=temp):
        print(1,2,n)
    else:
        print(-1)