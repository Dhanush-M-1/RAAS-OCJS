input_string = str(input())
new_string = input_string.split('+')


def sort_number(number):
    if len(number) > 1:
        swap_count = 1
        while swap_count > 0:
            swap_count = 0
            count = 0
            while count < len(number) - 1:
                if number[count] > number[count + 1]:
                    swap = number[count]
                    number[count] = number[count + 1]
                    number[count + 1] = swap
                    swap_count += 1
                count += 1
    return number


sorted_string = sort_number(number=new_string)

output_string = ''

for ind, number in enumerate(sorted_string):
    output_string += number
    if (ind + 1 != len(sorted_string)):
        output_string += '+'
print(output_string)