
t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split(" ")))
    chk=0
    for x in range(n-2):
        if a[x]+a[x+1]<=a[n-1]:
            print(x+1,x+2,n)
            chk=1
            break;
    if chk==0:
        print(-1)