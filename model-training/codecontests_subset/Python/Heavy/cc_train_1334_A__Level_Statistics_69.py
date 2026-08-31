testCases = int(input())
for _ in range(testCases):
    peek = int(input())
    values = []
    for i1 in range(peek):
        temp = list(map(int, input().split()))
        values.append(temp)
    result = 'YES'
    if values[0][0] < values[0][1]:
        result = 'NO'
    for i1 in range(1, peek, 1):
        playIncrease = values[i1][0] - values[i1 - 1][0]
        clearIncrease = values[i1][1] - values[i1 - 1][1]
        if not (playIncrease >= 0 and clearIncrease >= 0 and playIncrease >= clearIncrease):
            result = 'NO'
            break
    print(result)