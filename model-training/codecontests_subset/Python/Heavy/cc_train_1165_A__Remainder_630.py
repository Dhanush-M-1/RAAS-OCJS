def A():
    first_line = input().split()

    n = int(first_line[0])
    x = int(first_line[1])
    y = int(first_line[2])

    line = input()

    correct_line = "1" + (x - y - 1) * "0" + "1" + y * "0"

    result = 0

    for i in range(len(correct_line)):
        if line[len(line) - i - 1] != correct_line[len(correct_line) - i - 1]:
            if i != len(correct_line) - 1:
                result += 1

    print(result)


def C():
    n = int(input())

    line = input()

    result_count = 0
    result_line = ""

    i = 0

    while True:
        if i == (len(line) - 1):
            result_count += 1
            break

        if i >= len(line):
            break

        if line[i] != line[i + 1]:
            result_line += line[i] + line[i + 1]
            i += 2

        else:
            i += 1
            result_count += 1

    print(result_count)
    print(result_line)


if __name__ == '__main__':
    A()