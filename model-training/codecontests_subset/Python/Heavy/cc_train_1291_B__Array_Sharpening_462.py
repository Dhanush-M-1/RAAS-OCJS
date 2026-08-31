caseNum = int(input())

arrays = []

for i in range(caseNum):
    arrayLength = int(input())
    newArray = [int(n) for n in input().split()]
    arrays.append(newArray)

for i in range(len(arrays)):
    limit = 0
    sharpen = True
    increase = True
    for j in range(len(arrays[i])):
        if arrays[i][j] < limit:
            newLimit = len(arrays[i]) - j - 1
            if increase == False or arrays[i][j-1] <= newLimit:
                sharpen = False
                break
            increase = False
            limit = newLimit
            if arrays[i][j] < limit:
                sharpen = False
                break
        if increase:
            limit += 1
        else:
            limit -= 1
    if sharpen:
        print("Yes")
    else:
        print("No")