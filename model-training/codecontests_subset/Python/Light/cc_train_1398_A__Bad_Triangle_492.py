t = int(input())
while t > 0:
    n = int(input())
    x = list(map(int, input().split()))
    arr = list()
    arr2 = list()
    a = 0
    arr = sorted(x)
    for i in range(3, n+1):
        if arr[i-1] >= (arr[0] + arr[1]):
            print(1, 2, i)
            a = a + 1
            break
    if a == 0:
        print(-1)

    t = t - 1
