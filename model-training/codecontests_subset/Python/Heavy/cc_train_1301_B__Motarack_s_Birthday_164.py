for morzer in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    maxo, max1, min1 = 0, 0, 1e20
    for i in range(1, n):
        if arr[i] != -1 and arr[i - 1] != -1:
            maxo = max(abs(arr[i]-arr[i-1]), maxo)
        elif arr[i] != -1 and arr[i - 1] == -1:
            max1 = max(arr[i], max1)
            min1 = min(arr[i], min1)
        elif arr[i] == -1 and arr[i - 1] != -1:
            max1 = max(arr[i - 1], max1)
            min1 = min(arr[i - 1], min1)   
    if min1 == 1e20:
        print(0, 0)
    else:
        print(max(maxo, (max1 - min1 + 1) // 2), min1 + ((max1 - min1 + 1) // 2))    