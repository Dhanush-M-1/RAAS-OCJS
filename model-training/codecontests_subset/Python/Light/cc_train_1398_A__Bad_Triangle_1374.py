t=int(input())
for _ in range(t):
    n=int(input())
    i=0
    a=list(map(int,input().split()))
    if a[i]+a[i+1] <= a[-1]:
        print(i+1,i+2,n)
    else:
        print("-1")