# import numpy as np

def solution():
    params = input()
    params = params.split(" ")[1:]
    array_to_int(params)
    number = input()
    result = 0
    for i in range(0, params[0]):
        if i == params[1]:
            if number[len(number) - i - 1] != "1":
                result += 1
        elif number[len(number) - 1 - i] != "0":
            result += 1
    print(result)


def array_to_int(array):
    for i in range(len(array)):
        array[i] = int(array[i])
    return array


def join0(array):
    result = ""
    for i in array:
        result += str(i)
    return result


solution()
# input-output by console
