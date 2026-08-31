for _ in range(int(input())):
    temp = input()
    arr = list(map(int, input().split()))
    arr.sort()
    if arr[0] + arr[1] <= arr[-1]:
        print("%d %d %d"% (1, 2, len(arr)))    
    else:
        print("-1")
