def helpmath(str):
    list1 = []
    list2 = []
    str1=''
    length = len(str)
    for i in range(0,length,2):
        list1.append(int(str[i]))
    for i in list1:
        if i == 1:
            list2.append(i)
            list1[list1.index(i)] = 5
    for i in list1:
        if i == 2:
            list2.append(i)
            list1[list1.index(i)] = 6
    for i in list1:
        if i == 3:
            list2.append(i)
            list1[list1.index(i)] = 6
    for i in list2:
        str1+='%d'%i + '+'

    print (str1[0:-1])

str = input()
helpmath(str)