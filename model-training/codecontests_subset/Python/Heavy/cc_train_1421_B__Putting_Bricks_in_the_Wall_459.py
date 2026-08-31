t = int(input())
for i in range(t):
    n = int(input())
    arr = []
    for i in range(n):
        temp = list(input())
        arr.append(temp)
    res = []
    cnt = 0
    if arr[0][1]=='0' and arr[1][0]=='0':
        if arr[n-1][n-2] == '0':
            cnt += 1
            res.append([n,n-1])
        if arr[n-2][n-1] == '0':
            cnt += 1
            res.append([n-1,n])

    if arr[0][1]=='1' and arr[1][0]=='1':
        if arr[n-1][n-2] == '1':
            cnt += 1
            res.append([n,n-1])
        if arr[n-2][n-1] == '1':
            cnt += 1
            res.append([n-1,n])

    if arr[0][1]=='0' and arr[1][0]=='1':
        if arr[n-1][n-2] == '0' and arr[n-2][n-1] == '0':
            cnt += 1
            res.append([1,2])
        if arr[n-1][n-2] == '1' and arr[n-2][n-1] == '1':
            cnt += 1
            res.append([2,1])
        if arr[n-1][n-2] == '1' and arr[n-2][n-1] == '0':
            cnt += 2
            res.append([2,1])
            res.append([n-1,n])
        if arr[n-1][n-2] == '0' and arr[n-2][n-1] == '1':
            cnt += 2
            res.append([2,1])
            res.append([n,n-1])
        
    if arr[0][1]=='1' and arr[1][0]=='0':
        if arr[n-1][n-2] == '0' and arr[n-2][n-1] == '0':
            cnt += 1
            res.append([2,1])
        if arr[n-1][n-2] == '1' and arr[n-2][n-1] == '1':
            cnt += 1
            res.append([1,2])
        if arr[n-1][n-2] == '1' and arr[n-2][n-1] == '0':
            cnt += 2
            res.append([2,1])
            res.append([n,n-1])
        if arr[n-1][n-2] == '0' and arr[n-2][n-1] == '1':
            cnt += 2
            res.append([2,1])
            res.append([n-1,n])

    if cnt == 0:
        print(0)
    else:
        print(cnt)
        for i in res:
            print(*i)
