

testNumb = input ()
answers = []
for _ in range (int(testNumb)):
    inputsNumb = input()
    isCorrect = True
    previousInput = [0, 0]
    for i in range (int (inputsNumb)):
        newInput = input().split()
        newP = int(newInput[0])
        newC = int(newInput[1])
        
        if newC > newP:
            isCorrect = False
        if (i == 0):
            previousInput[0] = newP
            previousInput[1] = newC
        else:
            if newP < previousInput[0] or newC < previousInput[1] or (newC - previousInput[1]) > (newP - previousInput[0]):
                isCorrect = False      
            previousInput[0] = newP
            previousInput[1] = newC
    answers.append(isCorrect)

for i in range (len (answers)):
    if answers[i] == True:
        print ("YES")
    else:
        print ("NO")
