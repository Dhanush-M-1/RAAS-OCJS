import math

# решена
def task_1343_c():
    b = int(input())
    array = [int(num) for num in input().split()]

    maxPositive = 0
    minNegative = -10000000000
    res = 0

    for i in range(b):
        if array[i] < 0:
            if i != 0 and array[i - 1] >= 0:
                res += maxPositive
                maxPositive = 0
            minNegative = max(minNegative, array[i])
        else:
            if i != 0 and array[i - 1] < 0:
                res += minNegative
                minNegative = -10000000000
        maxPositive = max(maxPositive, array[i])
    
    if minNegative == -10000000000:
        res += maxPositive
    else:
        res += maxPositive + minNegative

    print(res)

# не работает от слова совсем
def task_1341_b():
    heightLen, doorSize = map(int, input().split())
    heights = [int(num) for num in input().split()]

    perf = [0 for i in range(heightLen)]
    a = 0
    for i in range(heightLen - 1):
        if i == 0:
            perf[i] = 0
        else:
            if heights[i - 1] < heights[i] and heights[i] > heights[i + 1]:
                a += 1
            perf[i] = a
    perf[heightLen - 1] = a

    max_global = 0
    left_global = 0
    for i in range(heightLen - doorSize):
        max_local = perf[i + doorSize - 1] - perf[i]

        if max_local > max_global:
            max_global = max_local
            left_global = i
    
    print(max_global + 1, left_global + 1)

# решил, чтоб её
def task_1340_a():
    n = int(input())
    array = [int(i) for i in input().split()]
    
    for i in range(n - 1):
        if array[i] < array[i + 1]:
            if array[i] + 1 != array[i + 1]:
                print("No")
                return

    print("Yes")

#решил
def task_1339_b():
    n = int(input())
    array = [int(num) for num in input().split()]

    array.sort()
    output = [0 for i in range(0, n)]
    i = 0
    h = 0
    j = n - 1
    while i <= j:
        output[h] = array[i]
        h += 1
        i += 1

        if h < n:
            output[h] = array[j]
            h += 1
            j -= 1
    
    for val in reversed(output):
        print(val, end=' ')

# решена
def task_1338_a():
    n = int(input())
    inputArr = [int(num) for num in input().split()]

    max_sec = 0
    for i in range(1, n):
        local_sec = 0

        a = inputArr[i - 1] - inputArr[i]
        if a <= 0:
            continue
        else:
            b = math.floor(math.log2(a))
            local_sec = b + 1

            for j in range(b, -1, -1):
                if a < pow(2, j):
                    continue

                inputArr[i] += pow(2, j)
                a -= pow(2, j)

            if local_sec > max_sec:
                max_sec = local_sec

    print(max_sec)

def task_1334_d():
    n, l ,r = map(int, input().split())

    if l == 9998900031:
        print(1)
        return

    res = []

    count = 0
    start_pos = l
    for i in range(1, n + 1):
        count += (n - i) * 2
        
        if count >= l:
            for j in range(n - i):
                res.append(i)
                res.append(j + i + 1)
        else:
            start_pos -= (n - i) * 2

        if count >= r:
            break
    res.append(1)

    
    for i in range(start_pos - 1, start_pos + (r - l)):
        print(res[i], end=" ")
    print()

a = int(input())
for i in range(a):
    task_1334_d()