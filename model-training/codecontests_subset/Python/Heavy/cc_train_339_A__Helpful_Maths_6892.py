i_input_string = input()

count_one = 0
count_two = 0
count_three = 0

for char in i_input_string:
    if char == '1':
        count_one += 1
    elif char == '2':
        count_two += 1
    elif char == '3':
        count_three += 1

final_str = ''

if count_one != 0:
    temp_str = '1+' * count_one
    final_str = final_str + temp_str

if count_two != 0:
    temp_str = '2+' * count_two
    final_str = final_str + temp_str

if count_three != 0:
    temp_str = '3+' * count_three
    final_str = final_str + temp_str

final_str = final_str[:-1]
print(final_str)