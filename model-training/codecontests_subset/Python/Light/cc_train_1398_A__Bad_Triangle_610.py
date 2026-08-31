def sum(n,a):
    if a[0]+a[1]<=a[n-1]:
        print(1,2,n,"\n")
    else:
        print(-1,"\n")
        
t=int(input())     
for e in range (t):
    n=int(input())
    a=list(map(int,input().split()))
    sum(n,a)