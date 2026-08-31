t = int(input())
for tc in range(t):
    n = int(input())
    count = 0
    flag = 0
    # while(1):
    #     if n % 6 == 0:
    #         break
    #     if n <= 10**9:
    #         n *= 2
    #         count += 1
    #     else:
    #         flag = 1
    # if flag == 0: 
    #     while(1):
    #         if n == 1:
    #             break
    #         if (n // 6) % 6 == 0 or (n // 6) % 6 == 1:
    #             count += 1
    #             break
    #         else:
    #             count += 1
    #             n //= 6
    #         print(n)
    while(n != 1):
        if n > 10**9:
            flag = 1
            break
        if n % 6 != 0:
            n *= 2
        else:
            n /= 6
        count += 1
        if n == 1:
            break
        # print(n)

    if flag != 1:
        print(count)
        continue
    print("-1")
    


        