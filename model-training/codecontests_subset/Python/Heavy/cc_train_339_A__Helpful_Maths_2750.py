line = input()


def sortN(numbers):
    if (len(numbers) == 1) or (len(numbers) == 0):
        return numbers
    num = numbers[0]

    left = []
    mid = []
    right = []
    for i in numbers:
        if i == num:
            mid.append(i)
        elif i < num:
            left.append(i)
        else:
            right.append(i)

    return sortN(left) + mid + sortN(right)


if len(line) == 1:
    print(line)
else:
    numbers = [int(i) for i in line.split("+")]
    numbers = sortN(numbers)
    print('+'.join(str(x) for x in numbers))

