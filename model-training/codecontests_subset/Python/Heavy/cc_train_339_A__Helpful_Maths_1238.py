def string(str1):
    count1operand = 0
    count2operator = 0
    add = ""
    list = []
    for i in str1:
        if i == '1':
            s = 1
            list.append(s)
            s = 0
        elif i == "2":
            s = 2
            list.append(s)
            s = 0
        elif i == "3":
            s = 3
            list.append(s)
            s = 0
    list.sort()
    for k in list:
        count1operand += 1
    for z in list:
        print(z,end = "")
        if count2operator < count1operand - 1:
            print("+",end="")
            count2operator += 1
string(input())



