def input_split(input_math):
    '''
    Splits the string input_math into a list of strings, removing the "+"
    '''
    alist = input_math.split("+")
    return alist

def SelectionSort(alist):
    '''
    Sort the elements in alist to be in ascending order
    '''
    for i in range(len(alist) - 1):
        minVal = alist[i]
        minIndex = i

        for j in range(i+1, len(alist)):
            if minVal > alist[j]:
                minVal = alist[j]
                minIndex = j

        tempVal = alist[i]
        alist[i] = minVal
        alist[minIndex] = tempVal
    return alist

def print_sum(alist):
    '''
    Takes in alist of strings, concatenate into a string with "+" added between each elements,and print it
    '''
    string = alist[0]
    for i in range(1,len(alist)):
        string = string + "+" + alist[i]
    print(string)

def main():
    s = input()
    sum_list = input_split(s)
    SelectionSort(sum_list)
    print_sum(sum_list)

main()
