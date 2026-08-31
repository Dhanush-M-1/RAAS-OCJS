from math import log, floor
t = int(input())
for case in range(t):
    n = int(input())
    count = 0
    if (n == 1):
        count = 0
    elif (n % 3 != 0):
        count = -1
    else:
        while n % 3 == 0:
            count += 1
            n = n // 3
        count_2 = 0
        while n % 2 == 0:
            count_2 += 1
            n = n // 2
        if (count_2 > count):
            count = -1
        else:
            if (n == 1):
                count += count - count_2
            else:
                count = -1
    print (count)