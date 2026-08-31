for i in range(int(input())):
    n = int(input())
    arr = [int(elem) for elem in input().split()]
    if arr[0]+arr[1] <= arr[-1]:
        print(1, 2, len(arr))
    else:
        print(-1)