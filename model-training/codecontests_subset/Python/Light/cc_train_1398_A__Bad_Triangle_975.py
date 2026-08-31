t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().strip().split(" ")))
    p=a[0];q=a[1];r=a[n-1]
    if p+q>r and p+r>q and q+r>p:
        print(-1)
    else:
        print(1,2,n)
