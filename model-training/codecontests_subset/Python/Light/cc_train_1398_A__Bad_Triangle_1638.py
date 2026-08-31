t = int(input())

while t>0:
    t-=1
    n = int(input())
    a = [[int(x),0] for x in input().split()]
    for i in range(n): a[i][1] = i+1
    a.sort(key=lambda x: x[0])

    if a[-1][0] >= a[0][0]+a[1][0]:
        print(a[0][1], a[1][1], a[-1][1])
    else:
        print(-1)