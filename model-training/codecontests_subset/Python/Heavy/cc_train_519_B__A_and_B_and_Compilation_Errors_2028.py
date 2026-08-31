for _ in range(1):
# for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    brr = list(map(int, input().split()))
    brr.sort()
    for i in range(n - 1):
        if arr[i] != brr[i]:
            print(arr[i])
            break
    else:
        print(arr[-1])
    arr = brr
    brr = list(map(int, input().split()))
    brr.sort()
    for i in range(n - 2):
        if arr[i] != brr[i]:
            print(arr[i])
            break
    else:
        print(arr[-1])


