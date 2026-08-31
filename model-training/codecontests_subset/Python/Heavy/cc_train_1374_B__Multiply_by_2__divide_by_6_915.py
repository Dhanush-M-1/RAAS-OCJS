import sys

TEST = 0

if TEST == 1:
    input_file = open("inputB.txt", "r")
    input_from_file = input_file.readlines()

def read_int():
    if TEST:
        return int(input_from_file.pop(0))
    else:
        return int(sys.stdin.readline())

def read_ints():
    if TEST:
        return list(map(int, input_from_file.pop(0).rstrip().split()))
    else:
        return list(map(int, sys.stdin.readline().split()))


def read_str():
    if TEST:
        in1 = input_from_file.pop(0).rstrip()
    else:
        in1 = sys.stdin.readline().rstrip()
    return in1

def read_str_to_list():
    if TEST:
        in1 = input_from_file.pop(0).rstrip()
    else:
        in1 = sys.stdin.readline().rstrip()
    return [x for x in in1]


tests = read_int()

for test in range(tests):
    n = read_int()

    steps = 0;
    while (n > 1):
        if n % 6 == 0:
            n /= 6
            steps += 1
        elif n % 3 == 0:
            n /= 3
            steps += 2
        else:
            steps = -1
            break

    print(steps)



