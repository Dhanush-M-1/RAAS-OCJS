for _ in range(int(input())):
    n = int(input())
    temp1, temp2 = n, n
    count3 = 0
    count2 = 0
    while True:
        if temp1 % 3 == 0:
            count3 += 1
            temp1 = temp1 // 3
        else:
            break
    while True:
        if temp2 % 2 == 0:
            count2 += 1
            temp2 = temp2 // 2
        else:
            break
    if (3 ** count3) * (2 ** count2) == n and count3 >= count2:
        print(count3 + count3 - count2)
    else:
        print(-1)
        
