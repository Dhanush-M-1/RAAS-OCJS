T = int(input())

for j in range(0, T):
    palString = list(input())
    n = len(palString)

    totalOperations = 0

    for i in range(0, n):
        if i > 0:
            if palString[i] == palString[i - 1] and palString[i] != '$':
                palString[i] = '$'
                totalOperations += 1
        if i > 1:
            if palString[i] == palString[i - 2] and palString[i] != '$':
                palString[i] = '$'
                totalOperations += 1

    print(totalOperations)
            
