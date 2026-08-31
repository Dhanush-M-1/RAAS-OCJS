
for _ in range(int(input())):
    n=int(input())
    a =list(map(int,input().split()))
    x,y,z=a[0],a[1],a[n-1]
    if(x+y >z):
        print(-1)
    else:
        print(1,2,n)