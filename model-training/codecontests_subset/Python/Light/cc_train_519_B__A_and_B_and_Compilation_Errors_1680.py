n = int(input())
firstLine  = list(map(int,input().split()))
secondLine = list(map(int,input().split()))
thirdLine  = list(map(int,input().split()))

firstLineSum  = sum(firstLine)
secondLineSum = sum(secondLine)
thirdLineSum  = sum(thirdLine)

print(firstLineSum - secondLineSum)
print(secondLineSum - thirdLineSum)