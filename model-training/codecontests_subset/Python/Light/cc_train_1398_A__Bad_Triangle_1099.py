for _ in range(int(input())):
    n = int(input())
    a  = list(map(int,input().split()))
    s = a[0]+a[1]
    c = False
    for i in range(2,n):
        if s<=a[i]:
            c = True
            break
    if c is True:
        print(1,2,i+1)
    else:
        print(-1)
