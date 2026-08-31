n = int(input())
for i in range(n):
    a = list(map(int,input().split(" ")))
    if a[1] >= a[2] >= a[0] or a[0] >= a[2] >= a[1]:
        if a[1] > a[0]:
            a[0],a[1] = a[1], a[0]
        print(a[0]//a[2]*a[2]+a[2])
    else:
        print(a[2])
