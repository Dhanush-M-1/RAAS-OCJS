n = int(input())
x = 0
res_list = []
while x < n:
    x += 1
    list_of_numbers = list(map(int, input().split()))
    counter = 0
    while list_of_numbers[1] and list_of_numbers[2] and list_of_numbers[2] != 1:
        counter += 3
        list_of_numbers[1] -= 1
        list_of_numbers[2] -= 2
    while list_of_numbers[0] and list_of_numbers[1] and list_of_numbers[1] != 1:
        counter += 3
        list_of_numbers[0] -= 1
        list_of_numbers[1] -= 2
    res_list.append(counter)
print('\n'.join(map(str, res_list)))
