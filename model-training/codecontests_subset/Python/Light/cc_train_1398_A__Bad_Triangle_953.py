t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(x) for x in input().split()]
    flag = 0
    if(a[0]+a[1]<=a[-1]):
        print(1,2,n)
        flag = 1
    if(flag==0):
        print(-1)