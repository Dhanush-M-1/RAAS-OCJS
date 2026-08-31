my_input = int(input())
my_num = []
my_list = []
for i in range(my_input):
    temp_list = []
    inp = int(input())
    my_num.append(inp)
    my_list.append([])
    for j in range(inp):
        my_list[i].append(input())
    if my_list[i][0][1] == '1':
        temp_list.append([1, 2])
    if my_list[i][1][0] == '1':
        temp_list.append([2, 1])
    if my_list[i][inp - 1][-2] == '0':
        temp_list.append([inp, inp - 1])
    if my_list[i][inp - 2][-1] == '0':
        temp_list.append([inp - 1, inp])
    if len(temp_list) > 2:
        temp_list2 = []
        if my_list[i][0][1] == '0':
            temp_list2.append([1, 2])
        if my_list[i][1][0] == '0':
            temp_list2.append([2, 1])
        if my_list[i][inp - 1][-2] == '1':
            temp_list2.append([inp, inp - 1])
        if my_list[i][inp - 2][-1] == '1':
            temp_list2.append([inp - 1, inp])
        print(len(temp_list2))
        for k in range(len(temp_list2)):
            print(temp_list2[k][0], temp_list2[k][1])
    else:
        print(len(temp_list))
        for k in range(len(temp_list)):
            print(temp_list[k][0], temp_list[k][1])
