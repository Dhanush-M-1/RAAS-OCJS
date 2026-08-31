import sys


def readlines(type=int):
    return list(map(type, sys.stdin.readline().split()))


def read(type=int):
    return type(sys.stdin.readline())


joint = lambda it, sep=" ": sep.join(
    [str(i) if type(i) != list else sep.join(map(str, i)) for i in it])


def main():
    n = read()
    e1 = readlines()
    e2 = readlines()
    e3 = readlines()
    e1_dict = dict()
    for error in e1:
        if error in e1_dict:
            e1_dict[error] += 1
        else:
            e1_dict[error] = 1
    e2_dict = dict()
    for error in e2:
        if error in e2_dict:
            e2_dict[error] += 1
        else:
            e2_dict[error] = 1
    e3_dict = dict()
    for error in e3:
        if error in e3_dict:
            e3_dict[error] += 1
        else:
            e3_dict[error] = 1
    d1 = dict()
    for key in e1_dict:
        if key not in e2_dict or e1_dict[key] - e2_dict[key] == 1:
            print(key)
            break
    for key in e2_dict:
        if key not in e3_dict or e2_dict[key] - e3_dict[key] == 1:
            print(key)
            break


if __name__ == "__main__":
    main()
