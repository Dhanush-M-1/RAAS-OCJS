def gcf(a, b):
    if b==0:
        return a
    return gcf(b, a%b)

def gcfList(numCount):
    a = numCount[0]
    for i in range(1, len(numCount)):
        a = gcf(a, numCount[i])
    return a

k = int(input())
stringList = list(input())
stringList.sort()
countPrintString = []
printString = []
possible = True
setStringList = list(set(stringList))
numCount = []

for character in setStringList:
    index2start = stringList.index(character)
    count = 0
    for i in range(index2start, len(stringList)):
        if stringList[i] == character:
            count += 1;
        else:
            break
    numCount.append(count)
for i in numCount:
    if i % k != 0:
        possible = False
if possible:
    divisor = gcfList(numCount)
    for i in range(len(numCount)):
        for j in range(numCount[i]//divisor):
            countPrintString.append(setStringList[i])
    while True:
        if len(printString)==len(stringList):
            break
        for letter in countPrintString:
            printString.append(letter)
    for character in printString:
        print(character, end='')
    #for i in range(len(stringList)//k):
     #   for letter in setStringList:
      #      print(letter, end = '')
else:
    print(-1)
