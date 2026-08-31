import sys


def cut_string(n, string):
    if n % 2 != 0:
        return 1, [string]

    zeros_count = 0
    for ch in string:
        if ch == '0':
            zeros_count += 1

    if zeros_count == n // 2:
        return 2, [string[:-1], string[-1]]
    else:
        return 1, [string]


if __name__ == '__main__':
    index = 0
    for line in sys.stdin:
        index += 1
        if index == 1:
            n = int(line)
            continue

        string = line.rstrip()

        k, answer = cut_string(n, string)

        print(k)
        print(' '.join(answer))
