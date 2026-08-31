t = int(input())
for case in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    minNum = 1000000000
    minInd = -1
    maxNum = 0
    maxInd = -1
    for i in range(n):
        num = a[i]
        if num < minNum:
            minInd = i
            minNum = num
        if num > maxNum:
            maxInd = i
            maxNum = num
    secondMin = 1000000000
    secondInd = -1
    for i in range(n):
        num = a[i]
        if num < secondMin:
            if i != minInd and i != maxInd:
                secondMin = num
                secondInd = i
    if minNum + secondMin <= maxNum:
        b = [minInd, secondInd, maxInd]
        b.remove(min(minInd, secondInd, maxInd))
        b.remove(max(minInd, secondInd, maxInd))
        middle = b[0]
        print(str(min(minInd, secondInd, maxInd) + 1) + " " + str(middle + 1) + " " + str(max(minInd, secondInd, maxInd) + 1))
    else:
        print(-1)
