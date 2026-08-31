for i in range(int(input())):

    number = int(input())

    counter = 0
    counter_infinity = 0

    while (number > 2) and (counter_infinity<2):
        residual_6 = number % 6

        if residual_6 == 0:
            number = number / 6
            counter = counter + 1
            counter_infinity = 0

        else:
            number = number*2
            counter = counter + 1       
            counter_infinity = counter_infinity + 1


    if number == 1:
        print(counter)

    else:
        print(-1)
