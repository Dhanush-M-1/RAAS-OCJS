def solve():
    n=int(input())
    a=list(map(int,input().split()))
    i,j=0,1
    tmp = a[0]+a[1]
    for k in range(2,n):
        if a[k]>= tmp:
            print(i+1,j+1,k+1)
            return
    print(-1)

for _ in range(int(input())):
    solve()
