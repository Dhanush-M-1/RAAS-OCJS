t = int(input())
for aaa in range(t):
    m = int(input())
    a = [int(aaa) for aaa in input().split()]
    if a[0] + a[1] <= a[-1]:
        print(1,2,m)
    else:
        print(-1)
