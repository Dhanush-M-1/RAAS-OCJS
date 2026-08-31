t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    flag = 0
    for i in range(2,n):
        if(a[0]+a[1]<=a[i]):
            print(1,2,i+1)
            flag = 1
            break
    if (flag==0):
        print(-1)

        