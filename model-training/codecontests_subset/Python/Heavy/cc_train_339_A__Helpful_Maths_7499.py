def sort(array):
    less = []
    equal = []
    greater = []

    if len(array) > 1:
        pivot = array[0]
        for x in array:
            if x < pivot:
                less.append(x)
            if x == pivot:
                equal.append(x)
            if x > pivot:
                greater.append(x)
        # Don't forget to return something!
        return sort(less)+equal+sort(greater)  # Just use the + operator to join lists
    # Note that you want equal ^^^^^ not pivot
    else:  # You need to hande the part at the end of the recursion - when you only have one element in your array, just return the array.
        return array

equation = input().replace('+', ' ').split()

sortd = sort(equation)
res = ''
for i in range(0,len(sortd)):
    if(i == len(sortd) - 1):
        res = res + sortd[i]
    else:
        res = res + sortd[i] + '+'
print(res)