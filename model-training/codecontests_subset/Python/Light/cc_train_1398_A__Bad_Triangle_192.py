t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    flag = 0
    if(a[0]+a[1]<=a[-1]):
        print(1,2,n)
    else:
        print(-1)