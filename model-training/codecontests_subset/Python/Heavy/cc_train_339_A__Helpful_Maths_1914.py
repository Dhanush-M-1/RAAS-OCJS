def sum_order():
    sum = input().split('+')
    one = 0
    two = 0
    three = 0
    for x in sum:
        x = int(x)
        if x == 1:
            one = one + 1
        elif x == 2:
            two = two + 1
        else:
            three = three + 1
    order_list = one*[1] + two*[2] + three*[3]
    i = 0
    for number in order_list:
        if i == 0:
            summon = f"{number}"
            i = i + 1
        else:
            summon = f"{summon}+{number}"
    print(summon)

sum_order()