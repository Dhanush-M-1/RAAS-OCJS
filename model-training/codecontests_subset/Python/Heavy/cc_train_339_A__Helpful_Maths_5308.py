def proper_sum_order(str) :
    l = str.split('+')
    a = l.count('1')
    b = l.count('2')
    c = l.count('3')
    for i in range(0, a) :
        if i == a-1 and b == 0 and c == 0 :
            print('1')
        else :
            print('1', end = '+')
    for i in range(0, b) :
        if i == b-1 and c == 0 :
            print('2')
        else :
            print('2', end = '+')
    for i in range(0, c) :
        if i == c-1 :
            print('3')
        else :
            print('3', end = '+')
str = input();
proper_sum_order(str)