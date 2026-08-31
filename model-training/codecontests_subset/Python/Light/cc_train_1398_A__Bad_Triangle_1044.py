t = int(input())

while t:
    n = int(input())
    a = [int(i) for i in input().split()]
    val1 = a[0]+a[1]
    if val1<=a[-1]:
        print(1,2,n)
    else:
        print(-1)
    t-=1