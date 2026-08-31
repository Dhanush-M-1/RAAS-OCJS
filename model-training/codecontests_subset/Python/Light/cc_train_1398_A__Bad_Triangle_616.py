for _ in range(int(input())):
    n = int(input())
    a = [*map(int,input().split())]
    ok = 0
    for i in range(2,n):
        if(a[i]>=a[0]+a[1]):
            print(1,2,i+1)
            ok = 1
            break
    if(not ok):
        print(-1)
