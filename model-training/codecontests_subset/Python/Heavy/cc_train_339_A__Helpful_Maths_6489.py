def re_arrange(expression):
    digits = []
    for num in expression:
        if num != "+" and num!= " ":
            digits.append(num)

    mergeSort(digits)

    result = ""
    for i in range(len(digits) - 1):
        result += digits[i] + "+"
    result += str(digits[len(digits)-1])

    return result

def mergeSort(aList):
    '''Sorts using merge sort'''
    """
        Complexity:
        Best - O(n log n)
        Worst - O(n log n)
    """
    tmp = [None] * len(aList)
    start = 0 #bottom boundary of the list in question
    end = len(aList) - 1 #top boundary of the list in question
    helperMergeSort(aList, start, end, tmp)
    return aList

def helperMergeSort(aList, start, end, tmp):
    if start < end: #2 or more still to sort
        mid = (start + end) // 2

        #split into two halves
        helperMergeSort(aList, start, mid, tmp)
        helperMergeSort(aList, mid + 1, end, tmp)

        #merge
        mergeLists(aList, start, mid, end, tmp)

        #copy tmp back into the original
        for i in range(start, end + 1):
            aList[i] = tmp[i]
    return

def mergeLists(aList, start, mid, end, tmp):
    i = start
    j = mid + 1
    for k in range(start, end + 1):
        if i > mid: #a finished, copy b
            tmp[k] = aList[j]
            j += 1
        elif j > end: #b finished, copy a
            tmp[k] = aList[i]
            i += 1
        elif aList[i] <= aList[j]: #aList[i] is the item to copy
            tmp[k] = aList[i]
            i += 1
        else: #aList[j] is the item to copy
            tmp[k] = aList[j]
            j += 1
    return
if __name__ == '__main__':
    expression = input()
    print(re_arrange(expression))