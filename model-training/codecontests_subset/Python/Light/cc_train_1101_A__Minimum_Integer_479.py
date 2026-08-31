n=int(input())
for i in range(0,n):
    a=(list(map(int, input().split())))
    if a[0]/a[2]>1:
        d=a[0]%a[2]
        if a[0]/a[2]>=2:
            print(a[2])
        elif d>0:
            print(a[2])
        else:
            print(((a[1] // a[2]) + 1) * a[2])
    else:
        print(((a[1]//a[2])+1)*a[2])
