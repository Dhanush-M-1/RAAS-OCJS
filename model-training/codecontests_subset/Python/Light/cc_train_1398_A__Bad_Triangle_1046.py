for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    present = dict()
    # for ind, a in enumerate(arr):
    #     if not present.get(a):
    #         present[a] = ind
    # arr = list(present.keys())
    if arr[0] + arr[1] <= arr[-1]:
        print(1, 2, len(arr))
    else:
        print(-1)
