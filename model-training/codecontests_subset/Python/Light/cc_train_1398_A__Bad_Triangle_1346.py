cases = int(input())
for t in range(cases):
    n = int(input())
    a = list(map(int,input().split()))
    p = a[0]+a[1]
    pos = -1
    for i in range(2,n):
        if a[i]>=p:
            pos = i
            break
    if pos == -1:
        print(-1)
    else:
        print(1,2,pos+1)