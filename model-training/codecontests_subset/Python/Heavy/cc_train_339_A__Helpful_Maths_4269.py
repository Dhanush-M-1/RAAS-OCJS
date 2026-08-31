def merge(a, b):
    a_ind = 0
    b_ind = 0
    res = []
    while a_ind < len(a) and b_ind < len(b):
        if a[a_ind] < b[b_ind]:
            res.append(a[a_ind])
            a_ind += 1
        else:
            res.append((b[b_ind]))
            b_ind += 1
    res += a[a_ind:] + b[b_ind:]
    return res


def merge_sort(L):
    if len(L) <= 1:
        return L
    left_part = L[:len(L)//2]
    right_part = L[len(L)//2:]
    return merge(merge_sort(left_part), merge_sort(right_part))


L = [int(i) for i in input().split("+")]
L1 = merge_sort(L)
print('+'.join([str(i) for i in L1]))