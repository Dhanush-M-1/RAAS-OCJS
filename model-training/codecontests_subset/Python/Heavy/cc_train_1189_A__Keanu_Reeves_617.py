n = int(input())
str = input()

cont1 = 0
cont0 = 0
ult = ""
list1 = []
for i in range(n):
    if(str[i] == '1'):
        cont1 += 1
    else:
        cont0 += 1
if(cont1 != cont0):
    print(1)
    print(str)
else:
    for i in range(n):
        if(str[i] == '1'):
            cont1 += 1
        else:
            cont0 += 1
        if(cont1 == cont0):
            list1.append(ult)
            ult = ""
            cont1 = 0
            cont2 = 0
        ult += str[i]
    list1.append(ult)
    print(len(list1))
    for i in range(len(list1)):
        if(i == n-1):
            print(list1[i])
        else:
            print(list1[i], end=" ")
