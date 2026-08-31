initial_len = int(input())
initial_list = sorted(list(map(int, input().split())))
second_list = sorted(list(map(int, input().split())))
third_list = sorted(list(map(int, input().split())))

for index, item in enumerate(initial_list):
    if index == len(second_list):
        print(item)
    else:
        if item != second_list[index]:
            print(item)
            break

for index, item in enumerate(second_list):
    if index == len(third_list):
        print(item)
    else:
        if item != third_list[index]:
            print(item)
            break
