for _ in range(int(input())):
    n = int(input())
    flag = 1
    lst = []
    for i in range(n):
        lst.append(tuple(map(int,input().split())))
    if lst[0][0] < lst[0][1]:
        print('NO')
        flag = 0
    if flag == 1:
        for i in range(1,n):
            if lst[i][0] < lst[i][1]:
                print('NO')
                flag = 0
                break
            if lst[i][0] < lst[i-1][0] or lst[i][1] < lst[i-1][1]:
                print('NO')
                flag = 0
                break
            elif lst[i][0] - lst[i-1][0] < lst[i][1]-lst[i-1][1]:
                print('NO')
                flag = 0
                break
    if flag == 1:
        print('YES')
            
