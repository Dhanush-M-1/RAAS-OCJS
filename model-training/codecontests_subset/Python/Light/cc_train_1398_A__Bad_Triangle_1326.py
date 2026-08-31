for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    flag = True
    temp = a[0] + a[1]
    x = 1
    y = 2
    for i in range(2, n):
        if temp <= a[i]:
            print(x, y, i+1)
            flag = False
            break
    if flag:
        print(-1)
