userinput = input()

if len(userinput) == 1:
    print(userinput)

else:
    lll = list()

    for l in userinput:
        lll.append(l)

    #print(lll)

    onlynumberslist = list()

    for i in lll[::2]:
        onlynumberslist.append(i)

    count1 = 0
    count2 = 0
    count3 = 0

    for number in onlynumberslist:
        if number == "1":
            count1 += 1
        elif number == "2":
            count2 += 1
        elif number == "3":
            count3 += 1

    newlist = list()

    for i in range(count1):
        newlist.append("+1")
    for i in range(count2):
        newlist.append("+2")
    for i in range(count3):
        newlist.append("+3")

    ans = "".join(newlist)

    print(ans[1:])

