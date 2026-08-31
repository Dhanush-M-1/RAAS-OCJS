n = int(input())

for i in range(n):
    mySet = set()
    t = int(input())
    numbers = [int(i) for i in input().split()]
    soFarMax = 0
    exchange = 0
    for index, number in enumerate(numbers):
        if number == -1:
            if index == 0:
                mySet.add(numbers[index + 1])
            elif index == t - 1:
                mySet.add(numbers[index - 1])
            else:
                mySet.add(numbers[index + 1])
                mySet.add(numbers[index - 1])
        else:
            if index == 0:
                if numbers[index + 1] != -1:
                    soFarMax = max(soFarMax, abs(numbers[index] - numbers[index + 1]))
            elif index == t - 1:
                if numbers[index - 1] != -1:
                    soFarMax = max(soFarMax, abs(numbers[index] - numbers[index - 1]))
            else:
                if numbers[index + 1] != -1:
                    soFarMax = max(soFarMax, abs(numbers[index] - numbers[index + 1]))
                if numbers[index - 1] != -1:
                    soFarMax = max(soFarMax, abs(numbers[index] - numbers[index - 1]))
    if -1 in mySet:
        mySet.remove(-1)
    if mySet:
        exchange = (min(mySet) + max(mySet)) // 2
        soFarMax = max(soFarMax, max(abs(exchange - min(mySet)), abs(exchange - max(mySet))))
    print(soFarMax, exchange)