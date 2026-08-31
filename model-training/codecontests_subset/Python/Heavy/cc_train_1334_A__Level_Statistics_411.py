t = int(input())

while t > 0:
    n = int(input())
    attempts = []
    for i in range(n):
        attempts.append([int(i) for i in input().split()])

    if attempts[0][0] < attempts[0][1] or attempts[-1][0] < attempts[-1][1]:
        print("NO")
        t -= 1
        continue

    
    flag = 1
    for i in range(1, n):
        a = attempts[i][0] - attempts[i-1][0]
        if a < 0 or attempts[i][1] - attempts[i-1][1] < 0 or attempts[i][1] - attempts[i-1][1] > a:
            flag = 0
            break


    if flag:
        print("YES")
    else:
        print("NO")

    t -= 1