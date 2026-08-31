count = int(input())
i = 0
res = 0
arr = []
while i < count:
    numbers = input()
    numbers = numbers.split()
    res = 0
    while int(numbers[1]) > 0 and int(numbers[2]) > 1:
        numbers[1] = int(numbers[1]) - 1
        numbers[2] = int(numbers[2]) - 2
        res += 3
    while int(numbers[0]) > 0 and int(numbers[1]) > 1:
        numbers[0] = int(numbers[0]) - 1
        numbers[1] = int(numbers[1]) - 2
        res += 3
    i += 1
    arr.append(res)

i = 0
while i < count:
    print(arr[i])
    i += 1