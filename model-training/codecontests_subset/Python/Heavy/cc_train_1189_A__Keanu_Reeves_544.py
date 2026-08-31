def check_good(line):
    zero_counter = 0
    one_counter = 0
    for s in line:
        if s == '0':
            zero_counter += 1
        else:
            one_counter += 1

    if zero_counter != one_counter:
        return True
    else:
        return False


if __name__ == "__main__":

    amount = int(input())
    line = input()

    if (amount % 2 != 0):
        print(1)
        print(line)
    else:
        if (check_good(line)):
            print(1)
            print(line)
        else:
            print(2)
            print(line[0], end=' ')
            print(line[1:amount])


