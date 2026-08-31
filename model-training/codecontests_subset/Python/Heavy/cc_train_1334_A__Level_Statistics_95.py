for _ in range(int(input())):
    n = int(input())
    arr = [0]*n
    for i in range(n):
        a,b = [int(s) for s in  input().split()]
        arr[i] = (a,b)
    flag = True
    if arr[0][1]>arr[0][0]:
        flag = False
    for i in range(1,len(arr)):
        if arr[i][1]>arr[i][0]:
            flag = False
            break
        if arr[i][1]<arr[i-1][1] or arr[i][0]<arr[i-1][0]:
            flag = False
        if arr[i][0]==arr[i-1][0] and arr[i][1]!=arr[i-1][1]:
            flag = False
        if arr[i][0]-arr[i-1][0] < arr[i][1]-arr[i-1][1]:
            flag = False
    if flag:
        print("YES")
    else:
        print("NO")
