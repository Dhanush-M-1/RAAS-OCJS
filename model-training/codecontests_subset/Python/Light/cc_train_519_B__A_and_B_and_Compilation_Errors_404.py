n = int(input())
input_list = list()
for i in range(3):
    input_temp = list(map(int, input().split()))
    input_list.append(input_temp)

for i in range(1, len(input_list)):
    list1 = list(input_list[i-1])
    list2 = list(input_list[i])

    unique_list1 = set(list1)
    unique_list2 = set(list2)

    if len(unique_list1.difference(unique_list2)) == 1:
        unique_value = [*unique_list1.difference(unique_list2), ]
        print(unique_value[0])
        continue

    for unique_value in unique_list1:
        if list1.count(unique_value) != list2.count(unique_value):
            print(unique_value)
            break
