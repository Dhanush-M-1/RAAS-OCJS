#1398A
for i in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    print(1,2,n) if a[0]+a[1] <= a[-1] else print(-1)
    