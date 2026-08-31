for _ in range(int(input())):
    n = int(input())
    a = list()
    flag = 0
    for i in range(n):
        x,y = map(int,input().split())
        a.append([x,y])
    if a[0][0] < a[0][1]:
        flag = 1
    else:
        for i in range(1,n):
            if a[i][0] - a[i-1][0] < a[i][1] - a[i-1][1]:
                flag = 1
                break
            if a[i][0] < a[i][1]:
                flag = 1
                break
            if a[i][0] < a[i-1][0]:
                flag = 1
                break
            if a[i][1] < a[i-1][1]:
                flag = 1
                break
    if flag == 1:
        print("No")
    else:
        print("Yes")
