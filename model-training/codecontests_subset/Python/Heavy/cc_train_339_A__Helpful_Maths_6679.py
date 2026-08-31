"""
:Created by: Peter Thomas
:Created on: 23/03/17
"""

def read_into_list(plusString):
    """

    :param plusString:
    :return:
    """
    plusStringClean = plusString.split("\n")[0]
    values = plusStringClean.split("+")
    return values

def selection_sort(the_array):
    """

    :param the_array:
    :return:
    """
    for k in range(len(the_array) - 1):
        minimum = k
        for j in range(k, len(the_array)):
            if the_array[j] < the_array[minimum]:
                minimum = j
        swap(the_array, minimum, k)

def swap(the_array, a, b):
    """

    :param the_array:
    :param a:
    :param b:
    :return:
    """
    temp = the_array[a]
    the_array[a] = the_array[b]
    the_array[b] = temp

def outputResults(the_list):
    """

    :param the_list:
    :return:
    """
    if(len(the_list) == 0):
        return ""
    elif len(the_list) == 1:
        return the_list[0]
    else:
        outString = ""
        for item in the_list:
            outString += str(item) + "+"
        return outString[:-1]

if __name__ == "__main__":
    the_string = input()
    numbersList = read_into_list(the_string)
    selection_sort(numbersList)
    print(outputResults(numbersList))