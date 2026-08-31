T = int(input())
for _ in range(T):
    num = int(input())
    count = 0
    flag = 1
    if num == 1:
        print(0)
        continue
    if num == 2:
        print("-1")
        continue
    while num != 1:
        if num == 2:
            flag = 0
            break
        if num % 6 == 0:
            num = num // 6
            count += 1
        else:
            num *= 2
            if num % 6 != 0:
                flag = 0
                break
            count += 1
    if flag:
        print(count)
    else:
        print("-1")