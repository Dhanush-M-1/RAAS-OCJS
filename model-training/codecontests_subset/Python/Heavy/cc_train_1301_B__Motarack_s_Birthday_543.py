import math
num_cases = int(input())
for i in range(num_cases):
    num_elements = int(input())
    array = [int(n) for n in input().split()]
    neighbors = list()
    maxDiff = 0
    for i in range(num_elements):
        if array[i] == -1:
            if i == 0:
                if array[i+1] != -1:
                    neighbors.append(array[i+1])
            elif i == num_elements-1:
                if array[i - 1] != -1:
                    neighbors.append(array[i - 1])
            else:
                if array[i + 1] != -1:
                    neighbors.append(array[i+1])
                if array[i - 1] != -1:
                    neighbors.append(array[i-1])
        elif i != num_elements - 1 and array[i + 1] != -1 and abs(array[i] - array[i + 1]) > maxDiff:
            maxDiff = abs(array[i] - array[i + 1])

    numberToReplace = round((max(neighbors, default=0) + min(neighbors, default=0)) / 2)
    maxDiff = max(maxDiff, abs(max(neighbors, default=0)-numberToReplace), abs(min(neighbors, default=0)-numberToReplace))
    if len(neighbors) == 0:
        print(str(maxDiff) + " 0")
    else:
        print(str(maxDiff) + " " + str(numberToReplace))
