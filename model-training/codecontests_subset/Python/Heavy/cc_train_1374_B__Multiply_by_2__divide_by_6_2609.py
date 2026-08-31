for _ in range(int(input())):
    y = int(input())
    if y == 1:
        print(0)
    elif y == 6:
        print(1)
    elif y == 3:
        print(2)
    elif y == 9:
        print(4)
    else:
        sum = 0
        if (y % 9 == 0):
            while y != 1:
                if (y % 6 == 0):
                    y = y//6
                    sum += 1
                else:
                    if y%2 == 0 or y%5 == 0:
                        sum = -1
                        break
                    else:
                        y = y*2
                        sum += 1
            print(sum)
        else:
            print(-1)