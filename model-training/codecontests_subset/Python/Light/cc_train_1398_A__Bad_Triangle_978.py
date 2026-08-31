t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))

    # print(a)
    x = a[0]
    y = a[1]

    res = 0
    for i in range(n-1, 1, -1):
        if x + y <= a[i]:
            res = i+1
            break

    if res == 0:
        print(-1)
    else:
        print('1 2', res)

