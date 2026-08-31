for x in range(int(input())):
    arr = [int(i) for i in input().split()]
    n = 1
    if arr[2] >= arr[0] and arr[2] <= arr[1]:
        n = int(arr[1]/arr[2]) +1 
    print(n*arr[2])
