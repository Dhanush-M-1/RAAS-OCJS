t = int(input())
while t:
    t = t - 1
    n = int(input())
    pair = list()
    arr = list()
    m = n
    flag = 1
    while n:
        n = n - 1
        pair = input().split()
        arr.append(pair)
    if int(arr[0][0]) < int(arr[0][1]):
        flag = 0
    for i in range(1, m, 1):
        if int(arr[i][0]) < int(arr[i-1][0]):
            flag = 0
        if int(arr[i][1]) < int(arr[i-1][1]):
            flag = 0
        if int(arr[i][0]) == int(arr[i-1][0]):
            if int(arr[i][1]) > int(arr[i-1][1]):
                flag = 0
        if int(arr[i][0]) < int(arr[i][1]):
            flag = 0
        if int(arr[i][0]) - int(arr[i-1][0]) < int(arr[i][1]) - int(arr[i-1][1]):
            flag = 0
    if flag:
        print('YES')
    else:
        print('NO')
