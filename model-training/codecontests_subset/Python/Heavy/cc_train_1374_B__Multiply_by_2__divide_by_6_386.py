fridge_numbers = [int(input()) for i in range(int(input()))]
fridge_counter = list()
for i in range(len(fridge_numbers)):
    counter_error = 0
    counter = 0
    while fridge_numbers[i] != 1 and counter_error != 100:
        counter_error += 1
        counter += 1
        if fridge_numbers[i] % 6 == 0:
            fridge_numbers[i] = fridge_numbers[i] // 6
        else:
            fridge_numbers[i] = fridge_numbers[i] * 2
    if counter_error == 100:
        fridge_counter.append(-1)
    else:
        fridge_counter.append(counter)
print(*fridge_counter, sep='\n')
