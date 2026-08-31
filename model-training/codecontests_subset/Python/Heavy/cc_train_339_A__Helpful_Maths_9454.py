inputString = input()
outputString = ""
i = 0
index1 = 0
index2 = 0
index3 = 0
while(i<len(inputString)):
    if int(inputString[i]) == 1:
        if index1 == i:
            outputString += "1+"
        else:
            outputString = outputString[:index1] + "1+" + outputString[index1:]
        index1+= 2
        index2+= 2
    elif int(inputString[i]) == 2:
        if index2 == i:
            outputString += "2+"
        else:
            outputString = outputString[:index2] + "2+" + outputString[index2:]
        index2+= 2
    else:
        outputString += "3+"
    i += 2
outputString = outputString[:len(outputString)-1]
print(outputString)