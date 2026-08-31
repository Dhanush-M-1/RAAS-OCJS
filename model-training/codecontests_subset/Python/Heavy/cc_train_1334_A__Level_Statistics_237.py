numTestCases = int(input())

cases = []
caseLengths = []

for i in range(numTestCases):
    caseLengths.append(int(input()))
    
    tempCases = []
    for j in range(caseLengths[i]):
        tempCases.append(list(map(int, input().split())))
    
    cases.append(tempCases)
    
for case in cases:

    isOkay = True

    isFirst = False

    if case[0][0] < case[0][1]:
        print('NO')
        isOkay = False
        isFirst = True

    if not isFirst:
        for i in range(1, len(case)):
            tempCase = case[i]
            tempCaseBack = case[i - 1]

            if tempCase[0] < tempCaseBack[0]:
                print('NO')
                isOkay = False
                break      
            elif tempCase[1] < tempCaseBack[1]:
                print('NO')
                isOkay = False
                break
            elif tempCase[0] < tempCase[1]:
                print('NO')
                isOkay = False
                break
            elif tempCase[1] - tempCaseBack[1] > tempCase[0] - tempCaseBack[0]:
                print('NO')
                isOkay = False
                break
    
    if isOkay:
        print('YES')