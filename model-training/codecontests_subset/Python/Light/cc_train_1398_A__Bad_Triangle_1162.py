for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    s = arr[0] + arr[1]
    flag = -1
    for i in range(2, n):
        if arr[i] >= s:
            flag = i+1
            break
    if flag == - 1:
        print(-1)
    else:
        print(1, 2, flag)