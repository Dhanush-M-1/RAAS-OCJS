def heapify(L, heap_size, root_ind):
    left_child_ind = 2 * root_ind + 1
    right_child_ind = 2*root_ind + 2
    max_ind = root_ind
    if left_child_ind < heap_size and L[left_child_ind] > L[max_ind]:
        max_ind = left_child_ind
    if right_child_ind < heap_size and L[right_child_ind] > L[max_ind]:
        max_ind = right_child_ind
    if max_ind != root_ind:
        L[root_ind], L[max_ind] = L[max_ind], L[root_ind]
        heapify(L, heap_size, max_ind)


def heap_sort(L):
    heap_size = len(L)
    start = len(L) // 2 - 1
    for i in range(start, -1, -1):
        heapify(L, heap_size, i)
    for j in range(heap_size - 1, 0, -1):
        L[j], L[0] = L[0], L[j]
        heapify(L, j, 0)
    return L


L = [int(i) for i in input().split("+")]
L1 = heap_sort(L)
print('+'.join([str(i) for i in L1]))