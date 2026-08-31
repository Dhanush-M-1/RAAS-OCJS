cases = int(input())
for x in range(cases):
    test = int(input())
    result = 0
    factorList = [0,0]
    while test > 1:
        if test % 2 == 0:
            factorList[0] += 1
            test //= 2
        elif test % 3 == 0:
            factorList[1] += 1
            test //= 3
        else:
            result = -1
            break
    if result != -1:
        if factorList[0] > factorList[1]:
            result = -1
        else:
            result = 2*factorList[1] - factorList[0]
    print(result)