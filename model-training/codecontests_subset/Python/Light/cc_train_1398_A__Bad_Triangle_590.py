for _ in range(int(input())):
    n = int(input())
    *arr, = map(int, input().split())
    # indices= sorted(range(n), key=lambda idx: arr[idx])
    if arr[0] + arr[1] <= arr[-1]:
        print(1, 2, len(arr))
    else:
        print(-1)

