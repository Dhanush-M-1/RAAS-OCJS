counter_1, counter_2, counter_3 = 0, 0, 0
s = input()
for elem in s:
    if elem == '1':
        counter_1 += 1
    elif elem == '2':
        counter_2 += 1
    elif elem == '3':
        counter_3 += 1
result = ''
for i in range(counter_1 - 1):
    result += '1' + '+'
if (counter_1 > 0):
    if (counter_2 > 0 or counter_3 > 0):
        result += '1' + '+'
    else:
        result += '1'
for i in range(counter_2 - 1):
    result += '2' + '+'
if counter_2 > 0:
    if counter_3 > 0:
        result += '2' + '+'
    else:
        result += '2'
for i in range(counter_3 - 1):
    result += '3' + '+'
if counter_3 > 0:
    result += '3'
print(result)