str = input()
res = ""
num1 = 0
num2 = 0
num3 = 0
for num in str:
    if num == '+':
        continue
    elif num == '1':
        num1 += 1
    elif num == '2':
        num2 += 1
    elif num == '3':
        num3 += 1
while num1 > 0:
    res += "1"
    num1 -= 1
    if num1 > 0 or num2 > 0 or num3 > 0:
        res += "+"
while num2 > 0:
    res += "2"
    num2 -= 1
    if num2 > 0 or num3 > 0:
        res += "+"
while num3 > 0:
    res += "3"
    num3 -= 1
    if num3 > 0:
        res += "+"
print(res)