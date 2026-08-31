n = int(input())
 
for i in range(n):
    y = int(input())
    a = list(map(int, input().split()))
    p = 0
    q = 0
    for k in range(2, y):
        if(a[0]+a[1]<=a[k]):
            p = 1
            q = k+1
            break
    if(p==0):
        print(-1)
    else:
        print(p, p+1, q)