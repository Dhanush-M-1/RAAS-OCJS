def Str2List(string):
    a = [digit for digit in string]
    return a

def findEight(List):
    a = 0
    for d in List:
        if d=="8":
            a+=1
    return a

cards = int(input())
digits = input()

numbers = 0

digits = Str2List(digits)
eights = findEight(digits)
lenofDigits = len(digits)
while lenofDigits >= 11 and eights>=1:
    eights -= 1
    lenofDigits -= 11
    numbers += 1
print(numbers)
