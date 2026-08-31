numbers = input()
numbers = numbers.strip()
num_list = ["1", "2", "3"]
new = []

for char in numbers:
    if char == "+":
        pass
    elif char in num_list:
        char = int(char)
        new.append(char)

counter = 1
final_str = ""

if len(new) == 1:
    print(new[0])

else:
    new.sort()


    for num in new:
        if counter == len(new):
            num = str(num)
            final_str += num
            print(final_str)
        else:
            num = str(num)
            final_str = final_str + num + "+"
        counter += 1
