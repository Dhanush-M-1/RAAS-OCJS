def merge_sort(a, start_index, end_index):
    if (start_index == end_index):
        return [a[start_index]]

    middle = (start_index + end_index) // 2
    x = merge_sort(a, start_index, middle)
    y = merge_sort(a, middle + 1, end_index)
    return merge(x, y)

def merge(a, b):
    c = []
    i = 0
    j = 0
    while (i < len(a) and j < len(b)):
        if (a[i] < b[j]):
            c.append(a[i])
            i += 1
        else:
            c.append(b[j])
            j += 1
    
    while (i < len(a)):
        c.append(a[i])
        i += 1
    
    while (j < len(b)):
        c.append(b[j])
        j += 1
    
    return c

numbers = [int(i) for i in input().split('+')]
sorted_numbers = merge_sort(numbers, 0, len(numbers) - 1)
print('+'.join([str(i) for i in sorted_numbers]))
