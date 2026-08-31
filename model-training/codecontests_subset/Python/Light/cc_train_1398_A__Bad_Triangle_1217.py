t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    i1, i2, i3 = a[0], a[1], a[-1]
    if i1 + i2 <= i3 or i1 + i3 <= i2 or i3 + i2 <= i1:
        print(1, 2, n)
    # for i in range(n-2):
    #     i1, i2, i3 = a[i], a[i+1], a[i+2]
    #     if i1 + i2 <= i3 or i1 + i3 <= i2 or i3 + i2 <= i1:
    #         print(i+1, i+2, i+3)
    #         break
    else:
        print(-1)
