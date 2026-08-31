#3
#7
#4 6 11 11 15 18 20
#4
#10 10 10 11
#3
#1 1 1000000000 
t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split())) 
    i=0
    k=n-1
    for m in range(1,n-1):
        if a[i]+a[m]<=a[k]:
            print(i+1,m+1,k+1)
            break 
    else:
        print(-1)