
def bs(arr):
    """ Bubble sort alghoritm to sort array from smallest to largest """

    to_sort = arr[:]
    l = len(to_sort)

    for i in range(l):
        for j in range(l):
            if j != (l - 1):
                if to_sort[j] > to_sort[j + 1]:
                    to_sort[j], to_sort[j + 1] = to_sort[j + 1], to_sort[j]
    
    return to_sort


def convert_to_math_op(arr):
    """ Convert arr [1, 2, 3, ...] --> 1+2+3+... """

    arr_str = list(map(str, arr[:]))
    new_s = "+"
    
    return new_s.join(arr_str)


s = list(map(int, input().split("+")))
sort_s = bs(s)
new_s = convert_to_math_op(sort_s)
print(new_s)
