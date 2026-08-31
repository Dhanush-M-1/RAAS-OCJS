from math import ceil


def get_list_halved(lst):
    mid = ceil(len(lst) / 2)
    return lst[:mid], lst[mid:]


def count_n(lst, n):
    return len(list(filter(lambda x: x == n, lst)))


def is_valid(lst):
    return count_n(lst, 0) != count_n(lst, 1)


input()

s = input()

ns = list(map(int, s))

if is_valid(ns):
    print(1)
    print(s)
else:
    print(2)
    h1, h2 = get_list_halved(ns)
    first = ''.join(list(map(str, h1)))
    if is_valid(h1) and is_valid(h2):
        print(first + ' ' + ''.join(list(map(str, h2))))
    else:
        print(first + str(h2[0]) + ' ' + ''.join(list(map(str, h2[1:]))))
