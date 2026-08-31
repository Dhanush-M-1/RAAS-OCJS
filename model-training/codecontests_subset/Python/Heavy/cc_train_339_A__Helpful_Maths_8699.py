def converter(str):
    numbers = str.split('+')

    for i in range(0, len(numbers)):
        for j in range(0, len(numbers) - 1):
            if numbers[j] > numbers[j + 1]:
                numbers[j], numbers[j + 1] = numbers[j + 1], numbers[j]

    reformatted_string = ''

    for i in range(0, len(numbers)):
        if i == 0:
            reformatted_string = reformatted_string + numbers[i]
        else:
            reformatted_string = reformatted_string + '+' + numbers[i]

    return reformatted_string

if __name__ == '__main__':
    x = input()
    print(converter(x))
