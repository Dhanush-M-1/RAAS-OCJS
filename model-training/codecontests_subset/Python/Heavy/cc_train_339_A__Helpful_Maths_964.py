input_str = input().strip()

numbers = {1:0, 2:0, 3:0}
for c in input_str:
    if(ord(c) >= 48 and ord(c) <= 51):
            numbers[int(c)] += 1



for one in range(numbers[1]):
    print("1", end = '')
    if(one - numbers[1] + 1):
        print("+", end = '')

if((numbers[2] or numbers[3]) and numbers[1]):
    print("+", end = "")

for two in range(numbers[2]):
    print("2", end = '')
    if(two - numbers[2] + 1):
        print("+", end = '')

if(numbers[3] and numbers[2]):
    print("+", end = "")

for three in range(numbers[3]):
    print("3", end = '')
    if(three - numbers[3] + 1):
        print("+", end = '')

print('')
