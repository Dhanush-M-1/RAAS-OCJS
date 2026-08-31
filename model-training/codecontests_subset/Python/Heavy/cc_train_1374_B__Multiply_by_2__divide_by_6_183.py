input_length = int(input())
while input_length != 0:
    numbernow = int(input())
    input_length -= 1
    numbercopy = numbernow
    if numbernow == 1:
        print(0)
        continue
    g = 0
    f = 0
    if numbercopy % 3 == 0:
        while (numbercopy % 3) == 0:
            numbercopy = numbercopy // 3
            g += 1
        if numbercopy % 2 == 0:
            while(numbercopy % 2) == 0 :
                numbercopy = numbercopy // 2
                f += 1
        if numbercopy == 1:
            if g >= f:
                print(2*g - f)
            else:
                print(-1)
        
        else:
            print(-1)
    else:
        print(-1)
    



