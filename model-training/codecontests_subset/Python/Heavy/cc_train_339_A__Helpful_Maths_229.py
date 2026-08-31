#339A

given_sum = str(input())

character_list = []

for i in given_sum:
    character_list.append(i)

number_of_characters = len(character_list)

op_list = []

for x in range(0, number_of_characters, 2):
        op_value = character_list[x]
        op_list.append(op_value)


def bubbleSort(op_list):
    n = len(op_list)
    for i in range(n - 1):
        for j in range(n - 1 - i):
            if op_list[j] > op_list[j+1]:
                op_list[j], op_list[j+1] = op_list[j+1], op_list[j]

bubbleSort(op_list)

count = 0

for x in range(0, number_of_characters, 2):
    character_list[x] = op_list[count]
    count = count + 1

for x in range(number_of_characters):
    print(character_list[x], end='') 

