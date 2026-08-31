t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    a = arr[0]
    b = arr[1]
    flag = False
    for i in range(2, n):
        if (a + b) <= arr[i]:
            print(1, 2, i + 1)
            flag = True
            break
    if flag is False:
        print(-1)