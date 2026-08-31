number_of_sets = int(input())
sets = []
for i in range(number_of_sets):
    temp = []
    numbers_of_linesegments = int(input())
    for k in range(numbers_of_linesegments):
        temp.append(tuple(map(int, input().split())))
    sets.append(temp)

for elem in sets:
    start = -1
    end = 10000000000
    for object in elem:
        if object[0] > start:
            start = object[0]
        if object[1] < end:
            end = object[1]
    if end > start:
        print(0)
    else:
        print(start - end)
