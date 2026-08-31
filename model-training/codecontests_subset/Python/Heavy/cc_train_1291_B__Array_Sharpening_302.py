for i in range(int(input())):
    n = int(input())
    x = list(map(int, input().split()))
    ans = 'Yes'
    flag = 0
    if n == 1 or n == 2 and x[0] != x[1] != 0:
        ans = 'Yes'
    elif n == 2 and x[0] == x[1] == 0:
        ans = 'No'
    else:
        for j in range(n):
            if x[j] < j:
                flag = 1
                break
        if flag == 1:
            maximum = x[0]
            for j in range(n):
                if x[j] < maximum or maximum < 0:
                    flag = 2
                    break
                maximum -= 1
        if flag == 2:
            flag2 = 0
            for j in range(n):
                if x[j] - j < 0:
                    flag2 = 1
                if flag2 == 1 and x[j - 1] < n - j:
                    flag = 3
    if flag == 3:
        ans = 'No'
    print(ans)
