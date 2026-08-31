my_input = input()
buttons,bulbs = my_input.split()
bulbs = int(bulbs)
temp = []
for x in range(int(buttons)):
    inp = input()
    my_list = inp.split()
    my_list = my_list[1:]
    for item in my_list:
        if item not in temp:
            temp.append(item)
if len(temp) == bulbs:
    print("YES")
else:
    print("NO")
