def easyMath(plusString):
    oneTwoThree = [0,0,0,0]
    charPos=0
    while charPos < len(plusString):
        try:
            char = int(plusString[charPos])
            oneTwoThree[char]+=1
            charPos+=2
        except:
            charPos+=1
    outputString=""
    pos=1
    while (pos<len(oneTwoThree)):
        while oneTwoThree[pos]>0:
            outputString+=str(pos)+"+"
            oneTwoThree[pos]-=1
        pos+=1
    outputString = outputString[:-1]
    return outputString
    
print(easyMath(input()))