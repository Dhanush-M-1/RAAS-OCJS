def func(arr):

    if arr[0][1] > arr[0][0]:
        print('NO')
        return

    for i in range(1, len(arr)):
        if (arr[i][0] < arr[i - 1][0] or arr[i][1] > arr[i][0] or
                arr[i][0] - arr[i - 1][0] < arr[i][1] - arr[i - 1][1] or arr[i][1] < arr[i - 1][1]):
            print('NO')
            return
    print('YES')


k = int(input())
for p in range(k):
    n = int(input())
    array = []
    for j in range(n):
        array.append(list(map(int, input().split())))
    func(array)
