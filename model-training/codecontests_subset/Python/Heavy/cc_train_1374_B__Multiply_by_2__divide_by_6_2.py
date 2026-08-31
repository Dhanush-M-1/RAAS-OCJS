def mulTwoDivSix(num: int) -> None:
    cont = True
    count = 0
    while (cont):
        if (num == 1):
            cont = False
        else:
            if (num % 6 == 0):
                num = num//6
            elif ((num % 1 == 0 or 2 % (num % 1) == 0) and num % 3 == 0):
                num *= 2
            else:
                cont = False
            count += 1

    if (num == 1):
        print(count)
    else:
        print(-1)
    return

test_cases = int(input())

for _ in range(test_cases):
    num = int(input())
    mulTwoDivSix(num)