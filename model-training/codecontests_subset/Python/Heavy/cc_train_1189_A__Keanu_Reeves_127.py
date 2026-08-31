n = int(input())
input_str = input()


def count_zeros_ones(line):
    counts = [0, 0]
    for el in line:
        if el == '0':
            counts[0] += 1
        else:
            counts[1] += 1
    return counts


def is_good(counts):
    if counts[0] == counts[1]:
        return False
    else:
        return True


def solution(line):
    counts = count_zeros_ones(line)
    if is_good(counts):
        print(1)
        print(line)
        return
    print(2)
    print(line[:1], ' ', line[1:])


solution(input_str)
