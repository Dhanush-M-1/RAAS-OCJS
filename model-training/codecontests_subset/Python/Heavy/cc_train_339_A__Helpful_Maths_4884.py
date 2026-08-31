istring = input()

# checking for the length of the string
#print(len(istring))



# case 1: when there is only one number
if len(istring) == 1:
    print(istring)

else:
    newistring = istring.replace("+","")
    #print(newistring)

    count1 = 0
    count2 = 0
    count3 = 0

    for number in newistring:
        if number == '3':
            count3 += 1
        elif number == '2':
            count2 += 1
        elif number == '1':
            count1 += 1

    #print(count1)
    #print(count2)
    #print(count3)

    finalstringlist = list()
    while count1 != 0:
        finalstringlist.append('+1')
        count1 -= 1
    while count2 != 0:
        finalstringlist.append('+2')
        count2 -= 1
    while count3 != 0:
        finalstringlist.append('+3')
        count3 -= 1

    finalstring = "".join(finalstringlist)
    #print(finalstring)

    ans = finalstring.replace('+','',1)
    print(ans)
















