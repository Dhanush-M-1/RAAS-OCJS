n = int(input())
first = second = third =''
printed = []
first = input().split(' ')
second = input().split(' ')
third = input().split(' ')
firstSum = 0
secondSum = 0
thirdSum = 0
for i in first:
    firstSum += int(i)
for i in second:
    secondSum += int(i)
for i in third:
    thirdSum += int(i)
print(firstSum - secondSum)
print(secondSum - thirdSum)