length = int(input())
myString = input()
myList = list(myString)
myNumberList = []
myWordList = []
for index in range(0, length - 1):
    myDouble = myList[index] + myList[index + 1]
    if myDouble in myWordList:
        x = myWordList.index(myDouble)
        myNumberList[x] += 1
    else:
        myNumberList.append(1)
        myWordList.append(myDouble)
myNumberList2 = myNumberList[:]
myNumberList2.sort()
myNumberList2.reverse()
aye = myNumberList.index(myNumberList2[0])
print(myWordList[aye])
