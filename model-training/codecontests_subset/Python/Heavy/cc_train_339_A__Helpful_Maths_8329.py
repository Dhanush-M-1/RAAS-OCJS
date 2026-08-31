s = input()
s = list(s)
num_of_1 = 0
num_of_2 = 0
num_of_3 = 0
num = 0
new_s = ''
count = 0
for i in range(len(s)):
    if s[i] == '1':
        num_of_1 += 1
        num += 1
    if s[i] == '2':
        num_of_2 += 1
        num += 1
    if s[i] == '3':
        num_of_3 += 1
        num += 1
for i in range(num_of_1):
    count += 1
    if count == num:
        new_s += '1'
    else:
        new_s += '1'
        new_s += '+'
for i in range(num_of_2):
    count += 1
    if count == num:
        new_s += '2'
    else:
        new_s += '2'
        new_s += '+'
for i in range(num_of_3):
    count += 1
    if count == num:
        new_s += '3'
    else:
        new_s += '3'
        new_s += '+'
print(new_s)
