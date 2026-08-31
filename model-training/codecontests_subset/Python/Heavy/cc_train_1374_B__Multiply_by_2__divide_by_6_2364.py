num = int(input())

for i in range(num):
    n = int(input())

    count1 = 0
    count2 = 0
    ac = 1
    ac2 = 1

    while n != 1:
        if n % 3 == 0:
            n /= 3
            count1 += 1
        else:
            ac = 0
            break

    while n != 1:
        if n % 2 == 0:
            n /= 2
            count2 += 1
        else:
            ac2 = 0
            break

    if ac == 0:
        if ac2 == 0 or count1 < count2:
            print(-1)
        else:
            print(2*count1 - count2)
    else:
        print(2*count1 - count2)



 
    
