def solve():
    n, s = list(map(int, input().split()))
    arr = list(map(int, input().split()))

    arr.sort()

    middle = n // 2

    if arr[middle] == s:
        print(0)
    elif arr[middle] > s:
        decrease = 0
        for i in range(middle, n):
            if arr[i] > s:
                decrease += arr[i] - s

        decrease_t = 0
        for i in range(0, middle + 1):
            if arr[i] > s:
                decrease_t += arr[i] - s

        print(min(decrease, decrease_t))
    else:
        increase = 0
        for i in range(middle, n):
            if arr[i] < s:
                increase += s - arr[i]

        increase_t = 0
        for i in range(0, middle + 1):
            if arr[i] < s:
                increase_t += s - arr[i]
        print(min(increase, increase_t))

solve()