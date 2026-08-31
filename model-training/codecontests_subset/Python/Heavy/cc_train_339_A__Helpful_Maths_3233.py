s = input()
numbers = []
strings = []

for i in range(len(s)):
    if i == 0:
        numbers.append(s[i])
    else:
        if i%2 == 0:
            numbers.append(s[i])
        else:
            strings.append(s[i])
def sort(numbers):
    for i in range(len(numbers)):
        minIndex = i
        for j in range(i+1, len(numbers)):
            if numbers[j] < numbers[minIndex]:
                minIndex = j

        numbers[i], numbers[minIndex] = numbers[minIndex], numbers[i]
    return numbers

numbers = sort(numbers)

sortedOutput = []
for i in range(len(strings)):
    sortedOutput.append(numbers[i])
    sortedOutput.append(strings[i])
sortedOutput.append(numbers[-1])
properOutput = ""
for item in sortedOutput:
    properOutput += item
print(properOutput)