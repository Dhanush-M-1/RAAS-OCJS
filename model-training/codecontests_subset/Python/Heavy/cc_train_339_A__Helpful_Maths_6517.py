import random


def quick_sort_divide(a):
    if len(a) <= 1:
        return a
    else:
        mark = random.choice(a)
        left_part = [i for i in a if i < mark]
        middle_part = [i for i in a if i == mark]
        right_part = [i for i in a if i > mark]
        return quick_sort_divide(left_part) + middle_part + quick_sort_divide(right_part)


def quick_sort(a, start, end):
    if start >= end:
        return a
    else:
        mark = random.choice(a)
        i = start
        j = end
        while i <= j:
            while a[i] < mark:
                i += 1
            while a[j] > mark:
                j -= 1
            if i <= j:
                a[i], a[j] = a[j], a[i]
                i += 1
                j -= 1
        quick_sort(a, start, j)
        quick_sort(a, i, end)
        return a


L = [int(i) for i in input().split("+")]
#L = [random.randint(-100, 100) for i in range(100)]
#LL = [random.randint(-100, 100) for i in range(100)]
L1 = quick_sort(L, 0, len(L) - 1)
#L2 = quick_sort_divide(L)
#print(L1)
#print(L2)
print('+'.join([str(i) for i in L1]))