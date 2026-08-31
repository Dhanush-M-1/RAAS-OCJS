testCases = int(input())
ret = []
for c in range(testCases):
    ret.append(0)
    first, second, third = map(int, input().split(" "))
    firstCheck, secondCheck = True, True
    while secondCheck:
        if second > 0 and third > 1:
            ret[c] += 3
            second = second - 1
            third = third - 2
        else:
            secondCheck = False
    while firstCheck:
        if first > 0 and second > 1:
            ret[c] += 3
            first = first - 1
            second = second - 2
        else:
            firstCheck = False
    

for result in ret:
    print(result)