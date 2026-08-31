# cook your dish here
t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    k=a[0]
    m=a[1]
    if a[n-1]>=k+m:
        print(1,2,n)
    else:
        print(-1)
        
    