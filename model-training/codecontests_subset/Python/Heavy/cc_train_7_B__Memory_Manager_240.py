
def alloc(array, number, arr_filled):
    req_zeroes = [0]*number
    flag = False
    if number <= len(array):
        for i in range((len(array)+1)-number):
            if array[i:i+number] == req_zeroes:
                flag = True
                if not arr_filled:
                    for j in range(i, i+number):
                        array[j] = 1
                    arr_filled.append(1)
                    print(1)
                    break
                else:
                    arr_filled.append(len(arr_filled) + 1)
                    for j in range(i, i + number):
                        array[j] = array_filled[-1]
                    print(array_filled[-1])
                    break
    if not flag:
        print('NULL')
    return array

def erase(array, arr_filled, to_erase):
    flag = False
    if to_erase not in arr_filled:
        print('ILLEGAL_ERASE_ARGUMENT')
    else:
        for i in range(len(array)):
            if array[i] == to_erase:
                array[i] = 0
                flag = True
            else:
                if flag:
                    break
        arr_filled[arr_filled.index(to_erase)] = '@'

    return array


def defragment(array, number, arr_filled):
    if arr_filled:
        array = [i for i in array if i != 0]
        new_number = number - len(array)
        for i in range(new_number):
            array.append(0)
    return array




t, m = map(int, input().split())
array = [0] * m
array_filled = []
for _ in range(t):
    string = input()
    if string != 'defragment':
        command, number = string.split()
        number = int(number)
        if command == 'alloc':
            array = alloc(array, number, array_filled)
        elif command == 'erase':
            array = erase(array, array_filled, number)
    else:
        array = defragment(array, m, array_filled)


