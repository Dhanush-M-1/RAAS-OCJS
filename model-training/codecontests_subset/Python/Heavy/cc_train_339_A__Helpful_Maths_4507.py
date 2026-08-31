string = str(input())
length = len(string)
output = []
num1 = string.count('1')
num2 = string.count('2')
num3 = string.count('3')
answer = "a"
for i in range(num1):
    output.append('1')
    if (i == (num1-1)) and (num2==0) and (num3==0):
        break
    else:
        output.append('+')
 
for j in range(num2):
    output.append('2')
    if (j == (num2-1)) and (num3==0):
        break
    else: 
        output.append('+')

for k in range(num3):
    output.append('3')
    if  (k == (num3-1)):
        break
    else:
        output.append('+')

output = "".join(output)
print(output)