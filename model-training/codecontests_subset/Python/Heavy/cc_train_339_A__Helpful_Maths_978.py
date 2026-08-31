n = input()
l = []

if len(n) <= 1:
    print(n)
    # meaning: a clean exit w/o problems
    exit(0)
else:
    for r in n:

        if r != '+':
            l.append(r)


def quick_sort(sequence):

    if len(sequence) <= 1:

        return sequence
    else:
        greater_than = []
        less_than = []
        pivot = sequence.pop()

        # saying: for each element in the sequence
        for elem in sequence:

            if elem > pivot:
                greater_than.append(elem)
            else:
                less_than.append(elem)

        return quick_sort(less_than) + [pivot] + quick_sort(greater_than)


sort_list = quick_sort(l)
final = []

for i in sort_list:
    final.append(str(i))
    final.append('+')

remove = final.pop()
# note that the join() function only works on string elements in sequences
print(''.join(final))