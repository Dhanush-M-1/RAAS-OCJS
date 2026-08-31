def quickSort(alist, first, last):
    '''
    Recusive QuickSort Alogrithm
    :param alist: the list to be sorted
    :param first: the first position
    :param last: the final position of the list
    :return: the sorted list
    '''
    if (last - first) > 1:
        # find pivot positioon
        pivot = alist[first]
        left_bad = first + 1
        right_bad = last - 1
        while left_bad <= right_bad:
            alist[left_bad], alist[right_bad] = alist[right_bad], alist[left_bad]
            if (alist[left_bad] <= pivot):
                left_bad = left_bad + 1
            elif (alist[right_bad] > pivot):
                right_bad = right_bad - 1
        alist[first], alist[right_bad] = alist[right_bad], alist[first]
        pivotPosition = right_bad
        quickSort(alist, first, pivotPosition)
        quickSort(alist, pivotPosition + 1, last)
    return alist

target = input().split('+')
quickSort(target, 0, len(target))
returnString = ""
for i in range(len(target)):
    returnString += target[i]
    if i != len(target)-1:
        returnString += "+"
print(returnString)