import math
total = int(input())
for i in range(0, total):
    number = int(input())
    if number == 1:
        print (0)
    elif number%3 != 0:
        print (-1)
    else:
        moves = 0
        while number%6 == 0:
            number = number/6
            moves += 1
        if number == 1:
            print (moves)
        else:
            if 1162261467 % number == 0:
                print (moves+(round(math.log(number)/math.log(3))*2))
            else:
                print (-1)
            
            
